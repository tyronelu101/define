package com.example.define.core.database.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation

@Entity(primaryKeys = ["word_id", "dictionary_id"])
data class WordDictionaryCrossRef(
    @ColumnInfo(name = "word_id") val wordId: Long,
    @ColumnInfo(name = "dictionary_id") val dictionaryId: String,
)

data class WordWithDictionary(
    @Embedded val word: WordEntity,
    @Relation(
        parentColumn = "word_id",
        entityColumn = "dictionary_id",
        associateBy = Junction(WordDictionaryCrossRef::class)
    )
    val dictionary: List<DictionaryEntity>,
)