package com.example.define.core.data.repository

import com.example.define.core.models.EntryModel
import com.example.define.core.network.DictionaryNetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DefaultDictionarySearchRepo @Inject constructor(
    private val userPreferenceRepository: UserPreferenceRepository,
    private val dictionaryRepository: DictionaryRepository,
    private val networkDataSource: DictionaryNetworkDataSource
) : DictionarySearchRepo {
    override fun searchDictionary(
        word: String,
        sourceLanguage: String,
        targetLanguage: String
    ): Flow<List<EntryModel>> {
        return dictionaryRepository.findEntries(word, sourceLanguage, targetLanguage)
    }
}