package com.example.define.core.data.repository

import com.example.define.core.database.daos.dictionary.DefinitionDao
import com.example.define.core.database.daos.dictionary.DictionaryDao
import com.example.define.core.database.daos.dictionary.PronunciationDao
import com.example.define.core.models.DictionaryModel
import com.example.define.core.models.EntryModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FakeDictionaryRepository @Inject constructor(
    private val dictionaryDao: DictionaryDao,
    private val entryDao: EntryDao,
    private val definitionDao: DefinitionDao,
    private val pronunciationDao: PronunciationDao
) : DictionaryRepository {

    val downloadedDictionaries = listOf(
        DictionaryModel("1", "English-Spanish Dictionary", "en", "es"),
        DictionaryModel("2", "English-French Dictionary", "en", "fr"),
        DictionaryModel("3", "English-German Dictionary", "en", "de"),
        DictionaryModel("4", "English-Chinese Dictionary", "en", "zh"),
        DictionaryModel("5", "English-Japanese Dictionary", "en", "ja"),
        DictionaryModel("6", "Chinese-English Dictionary","zh", "en"),
        DictionaryModel("7", "Chinese-Japanese Dictionary", "zh", "ja"),
        DictionaryModel("8", "Japanese-English Dictionary", "ja", "en"),
        DictionaryModel("9", "Spanish-English Dictionary", "es", "en"),
        DictionaryModel("10", "French-English Dictionary", "fr", "en"),
        DictionaryModel("11", "German-English Dictionary", "de", "en"),
        DictionaryModel("12", "Russian-English Dictionary", "ru", "en"),
        DictionaryModel("13", "Portuguese-English Dictionary", "pt", "en"),
        DictionaryModel("14", "Italian-English Dictionary", "it", "en"),
        DictionaryModel("15", "Korean-Chinese Dictionary", "ko", "zh"),
        DictionaryModel("16", "Vietnamese-English Dictionary", "vi", "en"),
        DictionaryModel("17", "Turkish-English Dictionary", "tr", "en"),
        DictionaryModel("18", "Polish-English Dictionary", "pl", "en"),
        DictionaryModel("19", "Dutch-English Dictionary", "nl", "en"),
        DictionaryModel("20", "Swedish-English Dictionary", "sv", "en"),
        DictionaryModel("21", "Thai-English Dictionary", "th", "en")
    )

    override suspend fun insertDictionary(dictionary: DictionaryModel) {

    }

    override suspend fun insertEntry(entry: EntryModel) {

    }

    override suspend fun getDictionary(uuid: String): DictionaryModel {
       return downloadedDictionaries[0]
    }

    override suspend fun getDictionariesSupportedFor(srcLanguageCode: String): List<DictionaryModel> {
        return downloadedDictionaries.filter {
            it.sourceLanguageCode == srcLanguageCode
        }
    }

    override suspend fun getAllDictionaries(): List<DictionaryModel> {
        return downloadedDictionaries
    }

    override fun findEntries(
        word: String,
        sourceLanguage: String,
        targetLanguage: String
    ): Flow<List<EntryModel>> {
        return flow {
//            listOf(EntryModel("word", emptyList(), emptyList(), DictionaryModel("", "", "", "")))
        }
    }


}