package com.example.define.core.data.repository

import com.example.define.core.data.models.SupportedLanguages
import com.example.define.core.models.LanguageSource
import com.example.define.core.network.DictionaryNetworkDataSource
import javax.inject.Inject

class DefaultSupportedLanguagesRepo @Inject constructor(
    private val dictionaryRepo: DictionaryRepository,
    private val dictionaryNetworkSource: DictionaryNetworkDataSource
) : SupportedLanguagesRepo {
    override suspend fun getAllSupportedLanguages(): List<SupportedLanguages> {

        //Need to get all the supported languages without filtering
        val localLanguages = dictionaryRepo.getAllDictionaries().map {
            SupportedLanguages(
                it.sourceLanguageCode,
                it.targetLanguageCode,
                source = LanguageSource.LOCAL
            )
        }
        val networkLanguages = dictionaryNetworkSource.getAllLanguages().map {
            SupportedLanguages(it.first, it.second, source = LanguageSource.REMOTE)
        }.filter { !localLanguages.map { it.srcLanguageCode }.contains(it.srcLanguageCode) }

        return localLanguages + networkLanguages
    }

    override suspend fun getSupportedLanguages(sourceLanguage: String): List<SupportedLanguages> {
//
//        val localLanguages = dictionaryRepo.getDictionariesSupportedFor(sourceLanguage).map {
//            SupportedLanguages(it, source = LanguageSource.LOCAL)
//        }
//        val networkLanguages = dictionaryNetworkSource.getLanguages(sourceLanguage).map {
//            SupportedLanguages(it, source = LanguageSource.REMOTE)
//        }.filter { !localLanguages.map { it.srcLanguageCode }.contains(it.srcLanguageCode) }

        return emptyList()
    }
}