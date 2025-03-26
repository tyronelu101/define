package com.example.define.core.network

interface DictionaryNetworkDataSource {
    suspend fun getSupportedLanguagesFor(srcLanguageCode: String): List<Pair<String, String>>
    suspend fun getAllLanguages(): List<Pair<String, String>>

}