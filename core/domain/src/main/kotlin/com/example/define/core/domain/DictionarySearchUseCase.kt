package com.example.define.core.domain

import com.example.define.core.data.repository.DictionarySearchRepo
import com.example.define.core.models.EntryModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DictionarySearchUseCase @Inject constructor(private val dictionarySearchRepo: DictionarySearchRepo) {

    operator fun invoke(
        query: String, sourceLanguage: String, targetLanguage: String
    ): Flow<List<EntryModel>> =
        dictionarySearchRepo.searchDictionary(query, sourceLanguage, targetLanguage)

}