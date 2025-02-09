package com.example.define.core.data.repository


interface SupportedLanguagesRepo {
    suspend fun getSupportedLanguages(): List<String>
}