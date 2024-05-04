package com.example.define.core.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    foreignKeys = [ForeignKey(
        entity = Dictionary::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("dictionary_id"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class Entry(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Long = 0L,
    @ColumnInfo(name = "dictionary_id") val dictionaryId: String


)
