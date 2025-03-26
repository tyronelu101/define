package com.example.define.feature.dictionary

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.define.core.data.models.RecentlySelectedLanguageModel
import com.example.define.core.data.repository.RecentlySelectedLanguageRepo
import com.example.define.core.data.repository.UserPreferenceRepository
import com.example.define.core.domain.GetSupportedLanguagesUseCase
import com.example.define.core.models.LanguageSelectionType
import com.example.define.core.models.LanguageSource
import com.example.define.feature.dictionary.SupportedLanguageItem.Header
import com.example.define.feature.dictionary.SupportedLanguageItem.Language
import com.example.define.feature.dictionary.navigation.LanguageRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Locale
import javax.inject.Inject

sealed class SupportedLanguageItem {
    data class Header(val text: String) : SupportedLanguageItem()
    data class Language(
        val languageCode: String = "",
        val languageName: String = "",
        val selected: Boolean = false,
        val dataSource: LanguageSource = LanguageSource.Unknown
    ) : SupportedLanguageItem()
}

@HiltViewModel
class LanguageScreenViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getSupportedLanguagesUseCase: GetSupportedLanguagesUseCase,
    private val recentlySelectedLanguageRepo: RecentlySelectedLanguageRepo,
    private val userPreferenceRepository: UserPreferenceRepository
) : ViewModel() {
    private val type = savedStateHandle.toRoute<LanguageRoute>().type

    private val _supportedLanguages: MutableStateFlow<List<SupportedLanguageItem>> =
        MutableStateFlow(emptyList())

    private val _searchText = MutableStateFlow("")

    val searchResults = _searchText.combine(_supportedLanguages) { text, languages ->
        if (text.isNotBlank()) {
            languages.filter {
                (it as? Language)?.languageName?.contains(
                    text,
                    ignoreCase = true
                ) == true
            }
        } else {
            languages
        }
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        _supportedLanguages.value
    )
    private var currentlySelectedSourceLanguage: String = ""
    private var currentlySelectedLanguageTargetLanguage: String = ""

    init {
        viewModelScope.launch {
            userPreferenceRepository.userPreferencesModel.map {
                currentlySelectedSourceLanguage = it.srcLanguage
                currentlySelectedLanguageTargetLanguage = it.targetLanguage
            }.first()

            loadLanguages(type)
        }
    }

    private fun loadLanguages(selectionType: LanguageSelectionType) {
        viewModelScope.launch {
            var currentlySelectedSourceLanguage = ""
            userPreferenceRepository.userPreferencesModel.map {
                currentlySelectedSourceLanguage = it.srcLanguage
            }.first()

            val recentlySelectedLanguages = withContext(Dispatchers.IO) {
                recentlySelectedLanguageRepo.getRecentlySelectedLanguages(selectionType)
            }.map { it.langCode }.filter { it != currentlySelectedSourceLanguage }

            val allSupportedLanguages = withContext(Dispatchers.IO) {
                getSupportedLanguagesUseCase(if (type == LanguageSelectionType.TARGET) currentlySelectedSourceLanguage else "")
            }.map {
                it.srcLanguageCode
            }.toSet()
                .filter { !recentlySelectedLanguages.contains(it) && it != currentlySelectedSourceLanguage }
                .sorted()

            val supportedLanguagesListRecent: MutableList<SupportedLanguageItem> = mutableListOf()
            supportedLanguagesListRecent.add(Header("Recent"))
            if (currentlySelectedSourceLanguage.isNotBlank()) {
                supportedLanguagesListRecent.add(
                    Language(
                        languageCode = currentlySelectedSourceLanguage,
                        languageName = Locale(currentlySelectedSourceLanguage).displayLanguage,
                        selected = true
                    )
                )
            }

            supportedLanguagesListRecent.addAll(recentlySelectedLanguages.map {
                Language(
                    languageCode = it,
                    languageName = Locale(it).displayLanguage
                )
            })

            val supportedLanguagesList: MutableList<SupportedLanguageItem> = mutableListOf()

            supportedLanguagesList.addAll(supportedLanguagesListRecent)
            supportedLanguagesList.add(Header("All Languages"))
            supportedLanguagesList.addAll(allSupportedLanguages.map {
                Language(
                    languageCode = it,
                    languageName = Locale(it).displayLanguage
                )
            })

            _supportedLanguages.value = supportedLanguagesList
        }
    }

    fun onLanguageSelect(languageCode: String) {
        viewModelScope.launch(Dispatchers.IO) {
            updateCurrentlySelectedLanguage(languageCode)
            updateRecentlySelectedLanguage(languageCode)
        }
    }

    private suspend fun updateCurrentlySelectedLanguage(languageCode: String) {
        if (type == LanguageSelectionType.SOURCE) {
            userPreferenceRepository.setSourceLanguage(languageCode)
        } else {
            userPreferenceRepository.setTargetLanguage(languageCode)
        }
    }

    private suspend fun updateRecentlySelectedLanguage(languageCode: String) {
        recentlySelectedLanguageRepo.insert(
            RecentlySelectedLanguageModel(
                type.ordinal,
                languageCode
            )
        )
    }

    fun onSearch(query: String) {
        _searchText.value = query
    }
}