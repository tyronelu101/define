package com.example.define.core.models

//Language is represented by ISO 639-1
data class UserPreferencesModel(
    val srcLanguage: String,
    val targetLanguage: String,
)