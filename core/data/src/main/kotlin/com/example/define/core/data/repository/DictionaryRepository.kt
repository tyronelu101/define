package com.example.define.core.data.repository

import com.example.define.core.models.DictionaryModel
import com.example.define.core.models.EntryModel
import kotlinx.coroutines.flow.Flow

interface DictionaryRepository {

    suspend fun insertDictionary(dictionary: DictionaryModel)

    suspend fun insertEntry(entry: EntryModel)

    suspend fun getDictionary(uuid: String): DictionaryModel

    suspend fun getAllDictionaries(): List<DictionaryModel>

    suspend fun getDictionariesSupportedFor(srcLanguageCode: String): List<DictionaryModel>

    fun findEntries(
        word: String,
        sourceLanguage: String,
        targetLanguage: String
    ): Flow<List<EntryModel>>
}