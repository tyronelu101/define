package com.example.define.core.domain

import com.example.define.core.data.models.SupportedLanguages
import com.example.define.core.data.repository.DictionaryRepository
import com.example.define.core.models.LanguageSource
import com.example.define.core.network.DictionaryNetworkDataSource
import javax.inject.Inject

class GetSupportedLanguagesUseCase @Inject constructor(
    private val dictionaryRepo: DictionaryRepository,
    private val dictionaryNetworkSource: DictionaryNetworkDataSource
) {

    //If arg is supplied, indicates looking for list of supported language of that source. Else gets all supported languages
    suspend operator fun invoke(srcLanguage: String = ""): List<SupportedLanguages> {
        val locallySupportedLanguages = getLocallySupportedLanguages(srcLanguage)

        //Exclude all of the language already on local/dictionaries that have been downloaded
        val remoteSupportedLanguages = getNetworkSupportedLanguages(srcLanguage).filter {
            !locallySupportedLanguages.contains(it)
        }

        return locallySupportedLanguages + remoteSupportedLanguages
    }

    private suspend fun getLocallySupportedLanguages(srcLanguage: String): List<SupportedLanguages> {
        val supportedLocalLanguages = if (srcLanguage.isBlank()) {
            dictionaryRepo.getAllDictionaries().map {
                SupportedLanguages(
                    it.sourceLanguageCode,
                    targetLanguageCode = it.targetLanguageCode,
                    source = LanguageSource.LOCAL
                )
            }
        } else {
            dictionaryRepo.getDictionariesSupportedFor(srcLanguage).map {
                SupportedLanguages(
                    it.sourceLanguageCode,
                    targetLanguageCode = it.targetLanguageCode,
                    source = LanguageSource.LOCAL
                )
            }
        }

        return supportedLocalLanguages
    }

    private suspend fun getNetworkSupportedLanguages(srcLanguage: String): List<SupportedLanguages> {
        val networkLanguages = if (srcLanguage.isBlank()) {
            dictionaryNetworkSource.getAllLanguages().map {
                SupportedLanguages(
                    it.first,
                    targetLanguageCode = it.second,
                    source = LanguageSource.REMOTE
                )
            }
        } else {
            dictionaryNetworkSource.getSupportedLanguagesFor(srcLanguage).map {
                SupportedLanguages(
                    it.first,
                    targetLanguageCode = it.second,
                    source = LanguageSource.REMOTE
                )
            }
        }

        return networkLanguages
    }
}