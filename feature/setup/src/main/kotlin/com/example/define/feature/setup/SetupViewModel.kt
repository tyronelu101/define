//package com.example.define.feature.setup
//
//import androidx.annotation.DrawableRes
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.define.core.data.repository.SupportedLanguagesRepo
//import com.example.define.core.domain.models.DictionarySource
//import com.example.define.core.domain.models.SupportedDictionaries
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.flow.asStateFlow
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.withContext
//import javax.inject.Inject
//
//data class SupportedLanguageItemUI(
//    @DrawableRes
//    val iconRes: Int,
//    val language: String,
//    val dictionarySource: List<DictionarySource>,
//    val isSelected: Boolean = false
//)
//
//
//@HiltViewModel
//class SetupViewModel @Inject
//constructor(
//    dictionarySourcesRepo: SupportedLanguagesRepo,
//) :
//    ViewModel() {
//
////    val dictionaryGroups: StateFlow<SetupListUIState> = dictionarySourcesRepo.getDictionarySources()
////        .transform { emit(transformDictionarySrcsToDictionaryItems(dictionarySrcs = it)) }
////        .onStart { emit(SetupListUIState.Loading) }
////        .stateIn(
////            scope = viewModelScope,
////            started = SharingStarted.WhileSubscribed(5_000),
////            initialValue = SetupListUIState.Loading
////        )
//
//    private val _supportedLanguages: MutableStateFlow<List<SupportedLanguageItemUI>> =
//        MutableStateFlow(emptyList())
//    val supportedLanguages: StateFlow<List<SupportedLanguageItemUI>> =
//        _supportedLanguages.asStateFlow()
//
//    init {
//        viewModelScope.launch {
//            val items: List<SupportedDictionaries> = withContext(Dispatchers.IO) {
//                dictionarySourcesRepo.getSupportedLanguages()
//            }
//
//            _supportedLanguages.value = items.map {
//                SupportedLanguageItemUI(R.drawable.flag_usa, it.language, it.dictionaries)
//            }
//        }
//    }
//
//    fun selectLanguage(language: String) {
//        _supportedLanguages.value = supportedLanguages.value.map {
//            if (it.language == language) {
//                SupportedLanguageItemUI(
//                    iconRes = it.iconRes,
//                    language = it.language,
//                    dictionarySource = it.dictionarySource,
//                    isSelected = !it.isSelected
//                )
//            } else {
//                it
//            }
//        }
//    }
//}