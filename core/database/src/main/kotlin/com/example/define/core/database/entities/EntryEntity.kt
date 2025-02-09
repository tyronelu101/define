package com.example.define.core.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    foreignKeys = [ForeignKey(
        entity = DictionaryEntity::class,
        parentColumns = arrayOf("uuid"),
        childColumns = arrayOf("dictionary_id"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class EntryEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Long = 0L,
    @ColumnInfo(name = "dictionary_id") val dictionaryId: String
)