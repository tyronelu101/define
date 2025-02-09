package com.example.define.core.data.models

import com.example.define.core.database.entities.RecentlySelectedLanguageEntity
import kotlinx.datetime.Instant

data class RecentlySelectedLanguageModel(
    val type: Int,
    val langCode: String,
    val selectedDate: Instant
)

fun RecentlySelectedLanguageModel.toEntity(): RecentlySelectedLanguageEntity =
    RecentlySelectedLanguageEntity(
        type = this.type,
        langCode = this.langCode,
        insertedDate = this.selectedDate
    )


fun RecentlySelectedLanguageEntity.toModel(): RecentlySelectedLanguageModel =
    RecentlySelectedLanguageModel(
        type = this.type,
        langCode = this.langCode,
        selectedDate = this.insertedDate
    )
