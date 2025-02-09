package com.example.define.core.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.datetime.Instant

@Entity(primaryKeys = ["type", "langCode"])
data class RecentlySelectedLanguageEntity(
    //0 is source, 1 is target
    @ColumnInfo("type") val type: Int,
    @ColumnInfo(name = "langCode") val langCode: String,
    @ColumnInfo("insertedDate") val insertedDate: Instant
)

