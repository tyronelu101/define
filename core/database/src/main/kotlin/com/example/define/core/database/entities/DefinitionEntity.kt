package com.example.define.core.database.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Junction
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = DictionaryEntity::class,
            parentColumns = arrayOf("dictionary_id"),
            childColumns = arrayOf("dictionary_id")
        )
    ]
)
data class DefinitionEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "definition_id") val id: Long = 0L,
    @ColumnInfo(name = "dictionary_id") val dictionaryId: String,
    @ColumnInfo(name = "definition") val definition: String,
    @ColumnInfo(name = "part_of_speech") val partOfSpeech: String
)

data class DefinitionWithDictionary(
    @Embedded val definition: DefinitionEntity,
    @Relation(
        parentColumn = "dictionary_id",
        entityColumn = "dictionary_id"
    )
    val dictionary: DictionaryEntity
)

data class DefinitionWithDictionaryAndPronunciations(
    @Embedded val definition: DefinitionEntity,
    @Relation(
        parentColumn = "dictionary_id",
        entityColumn = "dictionary_id"
    )
    val dictionary: DictionaryEntity,
    @Relation(
        parentColumn = "definition_id",
        entityColumn = "pronunciation_id",
        associateBy = Junction(WordPronunciationDefinitionCrossRef::class)
    )
    val pronunciations: List<PronunciationEntity>,
)

data class DefinitionWithPronunciationsAndDictionary(
    @Embedded val definition: DefinitionEntity,
    @Relation(
        parentColumn = "definition_id",
        entityColumn = "pronunciation_id",
        associateBy = Junction(WordPronunciationDefinitionCrossRef::class)
    )
    val pronunciations: List<PronunciationEntity>,

    @Relation(
        parentColumn = "dictionary_id",
        entityColumn = "dictionary_id")
    val dictionary: DictionaryEntity
)