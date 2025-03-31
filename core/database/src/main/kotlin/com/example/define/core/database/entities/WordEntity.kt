package com.example.define.core.database.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
data class WordEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "word_id") val id: Long = 0L,
    @ColumnInfo(name = "word") val word: String,
)

@Entity(primaryKeys = ["word_id", "pronunciation_id", "definition_id"])
data class WordPronunciationDefinitionCrossRef(
    @ColumnInfo(name = "word_id") val wordId: Long,
    @ColumnInfo(name = "pronunciation_id") val pronunciationId: Long,
    @ColumnInfo(name = "definition_id") val definitionId: Long
)

data class Entry(
    @Embedded val word: WordEntity,
    @Embedded val pronunciation: PronunciationEntity,
    @Embedded val definition: DefinitionEntity,
    @Embedded val dictionaryEntity: DictionaryEntity
)
