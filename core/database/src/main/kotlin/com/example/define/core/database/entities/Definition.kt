package com.example.define.core.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Entry::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("entry_id"),
        )
    ]
)
data class Definition(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo(name = "entry_id") val entryId: Long,
    @ColumnInfo(name = "definition") val definition: String,
    )
