package com.example.define.core.database.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.define.core.database.DefineDatabase
import com.example.define.core.database.daos.dictionary.DefinitionDao
import com.example.define.core.database.daos.dictionary.DictionaryDao
import com.example.define.core.database.daos.dictionary.PronunciationDao
import com.example.define.core.database.daos.dictionary.WordDao
import com.example.define.core.database.entities.DefinitionEntity
import com.example.define.core.database.entities.DefinitionWithDictionaryAndPronunciations
import com.example.define.core.database.entities.DictionaryEntity
import com.example.define.core.database.entities.PronunciationEntity
import com.example.define.core.database.entities.WordDictionaryCrossRef
import com.example.define.core.database.entities.WordEntity
import com.example.define.core.database.entities.WordPronunciationDefinitionCrossRef
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DictionaryTest {
    private lateinit var db: DefineDatabase
    private lateinit var dictionaryDao: DictionaryDao
    private lateinit var wordDao: WordDao
    private lateinit var pronunciationDao: PronunciationDao
    private lateinit var definitionDao: DefinitionDao

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, DefineDatabase::class.java).build()
        dictionaryDao = db.dictionaryDao()
        wordDao = db.wordDao()
        pronunciationDao = db.pronunciationDao()
        definitionDao = db.definitionDao()
        populateDatabase()
    }

    @After
    fun cleanup() {
        db.close()
    }

    @Test
    fun insertDictionary() {
        val result = dictionaryDao.getAll()
        assert(result.size == 2)
    }

    @Test
    fun insertWordWithDictionaryReturnsCorrectWordAndDictionary() {
        val resultWordDictionary = wordDao.getWordWithDictionary("行")

        assert(resultWordDictionary.word == WordEntity(id = 1, word = "行"))
        assert(
            resultWordDictionary.dictionary.contains(
                DictionaryEntity(
                    "CN_DICTIONARY_ID",
                    "ChineseDictionary",
                    "zh",
                    "en"
                )
            )
        )
        assert(
            resultWordDictionary.dictionary.contains(
                DictionaryEntity(
                    "JP_DICTIONARY_ID",
                    "JapaneseDictionary",
                    "jp",
                    "en"
                )
            )
        )
    }

    @Test
    fun insertDefinitionWithDictionaryReturnsDefinitionWithDictionary() {

        val dictionaryToMatch =
            DictionaryEntity("CN_DICTIONARY_ID", "ChineseDictionary", "zh", "en")

        val definitionsToMatch = arrayOf(
            DefinitionEntity(
                id = 3,
                dictionaryId = "CN_DICTIONARY_ID",
                definition = "ok, alright",
                partOfSpeech = "n"
            ),
            DefinitionEntity(
                id = 4,
                dictionaryId = "CN_DICTIONARY_ID",
                definition = "profession",
                partOfSpeech = "n"
            )
        )

        val definitionWithDictionaryResult1 = definitionDao.getDefinitionWithDictionary(3)
        val definitionWithDictionaryResult2 = definitionDao.getDefinitionWithDictionary(4)

        assert(definitionWithDictionaryResult1.definition == definitionsToMatch[0])
        assert(definitionWithDictionaryResult2.definition == definitionsToMatch[1])
        assert(definitionWithDictionaryResult1.dictionary == dictionaryToMatch)
        assert(definitionWithDictionaryResult2.dictionary == dictionaryToMatch)
    }

    @Test
    fun insertDefinitionWithDictionaryAndPronunciationsReturnsDefinitionWithDictionaryAndPronunciations() {
        val dictionaryToMatch =
            DictionaryEntity("CN_DICTIONARY_ID", "ChineseDictionary", "zh", "en")

        val definitionsToMatch = arrayOf(
            DefinitionEntity(3, "CN_DICTIONARY_ID", "ok, alright", "n"),
            DefinitionEntity(4, "CN_DICTIONARY_ID", "profession", "n")
        )

        val definitionWithDictionaryAndPronunciations3: DefinitionWithDictionaryAndPronunciations =
            definitionDao.getDefinitionWithDictionaryAndPronunciations(3)

        val definitionWithDictionaryAndPronunciations4 =
            definitionDao.getDefinitionWithDictionaryAndPronunciations(4)

        assert(
            definitionWithDictionaryAndPronunciations3 == DefinitionWithDictionaryAndPronunciations(
                definitionsToMatch[0],
                dictionaryToMatch,
                listOf(PronunciationEntity(3, "xíng"))
            )
        )
        assert(
            definitionWithDictionaryAndPronunciations4 == DefinitionWithDictionaryAndPronunciations(
                definitionsToMatch[1],
                dictionaryToMatch,
                listOf(PronunciationEntity(4, "háng"))
            )
        )
    }

    @Test
    fun insertWordWithDictionaryPronunciationAndDefinitionReturnsWordWithDefinitionDictionaryAndPronunciations() {
        val entry = wordDao.getPronunciation(3)
        val x = entry

        db.close()
    }

    private fun populateDatabase() {
        val jpDictionaryId = "JP_DICTIONARY_ID"
        val cnDictionaryId = "CN_DICTIONARY_ID"

        dictionaryDao.insert(DictionaryEntity(jpDictionaryId, "JapaneseDictionary", "jp", "en"))
        dictionaryDao.insert(DictionaryEntity(cnDictionaryId, "ChineseDictionary", "zh", "en"))

        wordDao.insert(WordEntity(1, "行"))
        wordDao.insertDictionaryWord(WordDictionaryCrossRef(1, jpDictionaryId))
        wordDao.insertDictionaryWord(WordDictionaryCrossRef(1, cnDictionaryId))

        val pronunciationsJP = arrayOf(
            PronunciationEntity(1, pronunciation = "こう"),
            PronunciationEntity(2, "ぎょう")
        )

        val pronunciationsCN = arrayOf(
            PronunciationEntity(3, "xíng"),
            PronunciationEntity(4, "háng"),
        )

        pronunciationDao.insert(*pronunciationsJP)
        pronunciationDao.insert(*pronunciationsCN)

        val definitionsJP =
            arrayOf(
                DefinitionEntity(1, jpDictionaryId, "line, row, verse", "n"),
                DefinitionEntity(2, jpDictionaryId, "going, traveling, journey, trip", "v"),
            )

        val definitionsCN =
            arrayOf(
                DefinitionEntity(3, cnDictionaryId, "ok, alright", "n"),
                DefinitionEntity(4, cnDictionaryId, "profession", "n")
            )

        definitionDao.insert(*definitionsJP)
        definitionDao.insert(*definitionsCN)

        wordDao.insertWordPronunciationDefinition(WordPronunciationDefinitionCrossRef(1, 1, 1))
        wordDao.insertWordPronunciationDefinition(WordPronunciationDefinitionCrossRef(1, 2, 2))
        wordDao.insertWordPronunciationDefinition(WordPronunciationDefinitionCrossRef(1, 3, 3))
        wordDao.insertWordPronunciationDefinition(WordPronunciationDefinitionCrossRef(1, 4, 4))

    }
}