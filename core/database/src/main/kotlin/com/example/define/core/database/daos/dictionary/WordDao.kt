package com.example.define.core.database.daos.dictionary

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.define.core.database.entities.PronunciationWithDefinitions
import com.example.define.core.database.entities.WordDictionaryCrossRef
import com.example.define.core.database.entities.WordEntity
import com.example.define.core.database.entities.WordPronunciationDefinitionCrossRef
import com.example.define.core.database.entities.WordWithDictionary
import com.example.define.core.database.entities.WordWithPronunciation


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
    @Query("SELECT * FROM WordEntity where word = :word")
    fun getWordWithPronunciation(word: String): WordWithPronunciation

    @Transaction
    @Query("SELECT * FROM PronunciationEntity where pronunciation_id = :id")
    fun getPronunciation(id: Long): PronunciationWithDefinitions

}
