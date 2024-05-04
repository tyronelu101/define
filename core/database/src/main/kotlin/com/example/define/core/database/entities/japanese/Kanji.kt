package com.example.define.core.database.entities.japanese

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Kanji(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo(name = "character") val character: String,
    @ColumnInfo(name = "meaning") val meaning: String
)
