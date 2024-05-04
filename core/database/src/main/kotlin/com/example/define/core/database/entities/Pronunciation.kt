package com.example.define.core.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Pronunciation(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "word") val word: String,
    @ColumnInfo(name = "pronunciation") val pronunciation: String,
    @ColumnInfo(name = "language") val language: String
)
