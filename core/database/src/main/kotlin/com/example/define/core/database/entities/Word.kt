package com.example.define.core.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(primaryKeys = ["word", "entry_id"],
    foreignKeys = [ForeignKey(
        entity = Entry::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("entry_id")
    )])
data class Word(
    @ColumnInfo(name = "word") val word: String,
    @ColumnInfo(name = "entry_id") val entryId: Long
)