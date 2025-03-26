package com.example.define.core.database.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DictionaryEntity(
    @PrimaryKey
    @ColumnInfo(name = "dictionary_id") val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "src_language") val srcLanguage: String,
    @ColumnInfo(name = "target_language") val targetLanguage: String
)

data class DictionaryWithDefinitionsAndPronunciations(
    @Embedded val dictionary: DictionaryEntity,
)