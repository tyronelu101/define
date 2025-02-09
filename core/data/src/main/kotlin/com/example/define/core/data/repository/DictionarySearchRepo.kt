package com.example.define.core.data.repository

import com.example.define.core.models.EntryModel
import kotlinx.coroutines.flow.Flow

interface DictionarySearchRepo {
    fun searchDictionary(
        word: String,
        sourceLanguage: String,
        targetLanguage: String
    ): Flow<List<EntryModel>>
}