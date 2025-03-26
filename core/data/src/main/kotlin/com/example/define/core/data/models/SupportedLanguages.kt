package com.example.define.core.data.models

import com.example.define.core.models.LanguageSource

data class SupportedLanguages(
    val srcLanguageCode: String,
    val targetLanguageCode: String,
    val source: LanguageSource
)
