package com.example.define.core.data.repository

import com.example.define.core.data.models.SupportedLanguages

interface SupportedLanguagesRepo {
    suspend fun getAllSupportedLanguages(): List<SupportedLanguages>
    suspend fun getSupportedLanguages(sourceLanguage: String): List<SupportedLanguages>
}