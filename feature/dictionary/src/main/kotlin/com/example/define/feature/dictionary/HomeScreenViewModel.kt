package com.example.define.feature.dictionary

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.define.core.data.repository.SupportedLanguagesRepo
import com.example.define.core.data.repository.UserPreferenceRepository
import com.example.define.core.domain.DictionarySearchUseCase
import com.example.define.core.models.EntryModel
import com.example.define.core.models.UserPreferencesModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val userPreferencesRepository: UserPreferenceRepository,
) : ViewModel() {

    val languagePreferences: StateFlow<UserPreferencesModel> =
        userPreferencesRepository.userPreferencesModel.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = UserPreferencesModel("", "")
        )
}