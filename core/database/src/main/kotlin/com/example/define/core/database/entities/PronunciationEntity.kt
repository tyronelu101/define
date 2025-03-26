package com.example.define.core.database.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Junction
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
data class PronunciationEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "pronunciation_id") val id: Long = 0L,
    @ColumnInfo(name = "pronunciation") val pronunciation: String,
)

data class PronunciationWithDefinitions(
    @Embedded val pronunciation: PronunciationEntity,
    @Relation(
        parentColumn = "pronunciation_id",
        entityColumn = "definition_id",
        associateBy = Junction(WordPronunciationDefinitionCrossRef::class)
    )
    val definitionWithDictionary: List<DefinitionEntity>
)
