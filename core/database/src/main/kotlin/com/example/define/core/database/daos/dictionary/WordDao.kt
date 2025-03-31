package com.example.define.core.database.daos.dictionary

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.define.core.database.entities.Entry
import com.example.define.core.database.entities.PronunciationWithDefinitions
import com.example.define.core.database.entities.WordDictionaryCrossRef
import com.example.define.core.database.entities.WordEntity
import com.example.define.core.database.entities.WordPronunciationDefinitionCrossRef
import com.example.define.core.database.entities.WordWithDictionary


@Dao
interface WordDao {

    @Insert
    fun insert(word: WordEntity): Long

    @Insert
    fun insertDictionaryWord(wordWithDictionary: WordDictionaryCrossRef)

    @Insert
    fun insertWordPronunciationDefinition(wordWithPronunciationsAndDefinitions: WordPronunciationDefinitionCrossRef)

    @Transaction
    @Query("SELECT * FROM WordEntity where word = :word")
    fun getWordWithDictionary(word: String): WordWithDictionary

    @Transaction
    @Query("SELECT * FROM PronunciationEntity where pronunciation_id = :id")
    fun getPronunciation(id: Long): PronunciationWithDefinitions

    //w.word, p.pronunciation, def.definition, def.part_of_speech, dic.name, dic.src_language, dic.target_language
    @Transaction
    @Query("SELECT * FROM WordEntity w " +
            "INNER JOIN WordPronunciationDefinitionCrossRef wpdcr on wpdcr.word_id = w.word_id " +
            "INNER JOIN PronunciationEntity p on wpdcr.pronunciation_id = p.pronunciation_id " +
            "INNER JOIN DefinitionEntity def on wpdcr.definition_id = def.definition_id " +
            "INNER JOIN DictionaryEntity dic on def.definition_owner_dictionary_id = dic.dictionary_id " +
            "WHERE w.word = :word AND dic.src_language = :srcLanguage AND dic.target_language = :targetLanguage")
    fun getEntries(word: String, srcLanguage: String, targetLanguage: String): List<Entry>
}
