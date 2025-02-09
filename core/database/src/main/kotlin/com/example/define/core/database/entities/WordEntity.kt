package com.example.define.core.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(primaryKeys = ["word", "entry_id"],
    foreignKeys = [ForeignKey(
        entity = EntryEntity::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("entry_id")
    )])
data class WordEntity(
    @ColumnInfo(name = "word") val word: String,
    @ColumnInfo(name = "entry_id") val entryId: Long
)