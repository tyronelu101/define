package com.example.dictionary_loaders.jp.jmdict

import com.example.define.core.database.daos.dictionary.DefinitionDao
import com.example.define.core.database.daos.dictionary.DictionaryDao
import com.example.define.core.database.daos.dictionary.PronunciationDao
import com.example.define.core.database.daos.dictionary.WordDao
import com.example.define.core.database.entities.DictionaryEntity
import com.example.define.core.database.entities.WordDictionaryCrossRef
import com.example.dictionary_loaders.jp.jmdict.models.JMdictWord
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import java.util.UUID

class JMdictLoader(
    private val dictionaryDao: DictionaryDao,
    private val entryDao: EntryDao,
    private val wordDao: WordDao,
    private val pronunciationDao: PronunciationDao,
    private val definitionDao: DefinitionDao,
    private val deserializer: JMdictDeserializer,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun load() {
        val dictionaryId = insertDictionary()
        deserializer.deserialize().collect {


        }
    }

    private fun processWord(dictionaryId: String, word: JMdictWord) {

        for (kanji in word.kanjis) {
            val entryId = entryDao.insert(WordDictionaryCrossRef(dictionaryId = dictionaryId))
            val word = wordDao

        }
    }

    private suspend fun insertDictionary(): String {
        val uuid = UUID.randomUUID()
        val dictionary = DictionaryEntity(uuid.toString(), "JMDict", "jp", "en")
        dictionaryDao.insert(dictionary)
        return uuid.toString()
    }
}