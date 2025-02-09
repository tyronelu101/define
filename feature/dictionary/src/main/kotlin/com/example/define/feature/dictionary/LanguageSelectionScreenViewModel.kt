package com.example.define.feature.dictionary

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.define.core.data.repository.RecentlySelectedLanguageRepo
import com.example.define.core.data.repository.SupportedLanguagesRepo
import com.example.define.core.data.repository.UserPreferenceRepository
import com.example.define.feature.dictionary.SupportedLanguageItem.Header
import com.example.define.feature.dictionary.SupportedLanguageItem.Language
import com.example.define.feature.dictionary.navigation.LanguageRoute
import com.example.define.feature.dictionary.types.LanguageSelectionType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Locale
import javax.inject.Inject

enum class LanguageSource {
    Unknown, LOCAL, REMOTE
}

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
    private val supportedLanguagesRepo: SupportedLanguagesRepo,
    private val recentlySelectedLanguageRepo: RecentlySelectedLanguageRepo,
    private val userPreferenceRepository: UserPreferenceRepository
) : ViewModel() {

    private val type = savedStateHandle.toRoute<LanguageRoute>().type

    private val _supportedLanguages: MutableStateFlow<List<SupportedLanguageItem>> =
        MutableStateFlow(emptyList())

    private val _searchText = MutableStateFlow("")

    val searchResults = _searchText.combine(_supportedLanguages) { text, languages ->
        Log.i("Test", "Searching $text")
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

    init {
        loadLanguages(type)
    }

    private fun loadLanguages(selectionType: LanguageSelectionType) {
        viewModelScope.launch {
            val currentlySelectedLanguage = userPreferenceRepository.userPreferencesModel.map {
                if (type == LanguageSelectionType.SOURCE) {
                    it.srcLanguage
                } else {
                    it.targetLanguage
                }
            }.first()

            val recentlySelectedLanguages = withContext(Dispatchers.IO) {
                recentlySelectedLanguageRepo.getRecentlySelectedLanguages(selectionType.ordinal)
            }.map { it.langCode }.filter { it != currentlySelectedLanguage }

            val supportedLanguagesList: MutableList<SupportedLanguageItem> = mutableListOf()
            supportedLanguagesList.add(Header("Recent"))
            supportedLanguagesList.add(
                Language(
                    languageCode = currentlySelectedLanguage,
                    languageName = Locale(currentlySelectedLanguage).displayLanguage,
                    true
                )
            )
            supportedLanguagesList.addAll(recentlySelectedLanguages.map {
                Language(
                    languageCode = it,
                    languageName = Locale(it).displayLanguage
                )
            }.sortedBy { it.languageName })

            val allSupportedLanguages = withContext(Dispatchers.IO) {
                supportedLanguagesRepo.getSupportedLanguages().filter {
                    !recentlySelectedLanguages.contains(it)
                }.filter {
                    currentlySelectedLanguage != it
                }
            }
            supportedLanguagesList.add(Header("All Languages"))
            supportedLanguagesList.addAll(allSupportedLanguages.map {
                Language(
                    languageCode = it,
                    languageName = Locale(it).displayLanguage
                )
            }.sortedBy { it.languageName })

            _supportedLanguages.value = supportedLanguagesList
        }
    }

    fun onLanguageSelected(languageCode: String) {
        Log.i("Test", "Language code clicked: $languageCode")
        viewModelScope.launch {
            if (type == LanguageSelectionType.SOURCE) {
                userPreferenceRepository.setSourceLanguage(languageCode)
            } else {
                userPreferenceRepository.setTargetLanguage(languageCode)
            }
        }
    }

    fun onSearch(query: String) {
        Log.i("Test", "Searching onSearch $query")
        _searchText.value = query
    }
}