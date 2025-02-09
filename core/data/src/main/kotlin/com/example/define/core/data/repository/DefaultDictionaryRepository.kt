package com.example.define.core.data.repository

import com.example.define.core.database.daos.DefinitionDao
import com.example.define.core.database.daos.DictionaryDao
import com.example.define.core.database.daos.EntryDao
import com.example.define.core.database.daos.PronunciationDao
import com.example.define.core.database.daos.WordDao
import com.example.define.core.database.entities.DictionaryEntity
import com.example.define.core.models.DictionaryModel
import com.example.define.core.models.EntryModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.UUID
import javax.inject.Inject

class DefaultDictionaryRepository @Inject constructor(
    private val dictionaryDao: DictionaryDao,
    private val entryDao: EntryDao,
    private val wordDao: WordDao,
    private val definitionDao: DefinitionDao,
    private val pronunciationDao: PronunciationDao

) : DictionaryRepository {
    override suspend fun insertDictionary(dictionary: DictionaryModel) {
        val uuid = UUID.randomUUID().toString()
        dictionaryDao.insert(
            DictionaryEntity(
                uuid = uuid,
                name = dictionary.name,
                language = dictionary.sourceLanguage
            )
        )
    }

    override suspend fun insertEntry(entry: EntryModel) {

    }

    override suspend fun getLanguages(): List<String> {
        return emptyList()
    }

    override fun findEntries(
        word: String,
        sourceLanguage: String,
        targetLanguage: String
    ): Flow<List<EntryModel>> {
        return flow {
            listOf(EntryModel("word", emptyList(), emptyList(), DictionaryModel("", "", "", "")))

        }
    }


}