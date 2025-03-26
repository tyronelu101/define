package com.example.define.core.data.repository

import com.example.define.core.database.daos.dictionary.DefinitionDao
import com.example.define.core.database.daos.dictionary.DictionaryDao
import com.example.define.core.database.daos.dictionary.PronunciationDao
import com.example.define.core.database.entities.DictionaryEntity
import com.example.define.core.database.entities.toModel
import com.example.define.core.models.DictionaryModel
import com.example.define.core.models.EntryModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.UUID
import javax.inject.Inject

class DefaultDictionaryRepository @Inject constructor(
    private val dictionaryDao: DictionaryDao,
    private val entryDao: EntryDao,
    private val definitionDao: DefinitionDao,
    private val pronunciationDao: PronunciationDao

) : DictionaryRepository {
    override suspend fun insertDictionary(dictionary: DictionaryModel) {
        val uuid = UUID.randomUUID().toString()
        dictionaryDao.insert(
            DictionaryEntity(
                uuid = uuid,
                name = dictionary.name,
                srcLanguage = dictionary.sourceLanguageCode,
                targetLanguage = dictionary.targetLanguageCode
            )
        )
    }

    override suspend fun insertEntry(entry: EntryModel) {

    }

    override suspend fun getDictionary(uuid: String): DictionaryModel {
//        return dictionaryDao.get(uuid)
        return DictionaryModel("", "", "", "")
    }

    override suspend fun getAllDictionaries(): List<DictionaryModel> = dictionaryDao.getAll().map {
        it.toModel()
    }

    override suspend fun getDictionariesSupportedFor(srcLanguageCode: String): List<DictionaryModel> {
        return emptyList()
    }

    override fun findEntries(
        word: String,
        sourceLanguage: String,
        targetLanguage: String
    ): Flow<List<EntryModel>> {
        return flow {

        }
    }


}