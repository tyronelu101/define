package com.example.define.core.network

import javax.inject.Inject

class FakeDictionaryNetworkDataSource @Inject constructor() : DictionaryNetworkDataSource {
    val remoteSupportedLanguages = listOf(
        "en" to "es",  // English → Spanish
        "en" to "fr",  // English → French
        "en" to "de",  // English → German
        "en" to "zh",  // English → Chinese
        "en" to "ja",  // English → Japanese
        "zh" to "en",  // Chinese → English
        "zh" to "ja",  // Chinese → Japanese
        "zh" to "ko",  // Chinese → Korean
        "ja" to "en",  // Japanese → English
        "ja" to "zh",  // Japanese → Chinese
        "ja" to "ko",  // Japanese → Korean
        "es" to "en",  // Spanish → English
        "es" to "fr",  // Spanish → French
        "fr" to "en",  // French → English
        "fr" to "es",  // French → Spanish
        "de" to "en",  // German → English
        "de" to "fr",  // German → French
        "hi" to "en",  // Hindi → English
        "hi" to "bn",  // Hindi → Bengali
        "ar" to "en",  // Arabic → English
        "ar" to "fr",  // Arabic → French
        "ru" to "en",  // Russian → English
        "ru" to "uk",  // Russian → Ukrainian
        "pt" to "en",  // Portuguese → English
        "pt" to "es",  // Portuguese → Spanish
        "it" to "en",  // Italian → English
        "it" to "fr",  // Italian → French
        "ko" to "zh",  // Korean → Chinese
        "ko" to "ja",  // Korean → Japanese
        "bn" to "hi",  // Bengali → Hindi
        "vi" to "en",  // Vietnamese → English
        "vi" to "fr",  // Vietnamese → French
        "tr" to "en",  // Turkish → English
        "tr" to "de",  // Turkish → German
        "pl" to "en",  // Polish → English
        "pl" to "de",  // Polish → German
        "uk" to "en",  // Ukrainian → English
        "uk" to "ru",  // Ukrainian → Russian
        "nl" to "en",  // Dutch → English
        "nl" to "fr",  // Dutch → French
        "sv" to "en",  // Swedish → English
        "sv" to "de",  // Swedish → German
        "th" to "en"   // Thai → English
    )

    override suspend fun getSupportedLanguagesFor(srcLanguageCode: String): List<Pair<String, String>> {
        return remoteSupportedLanguages.filter {
            it.first == srcLanguageCode
        }
    }

    override suspend fun getAllLanguages(): List<Pair<String, String>> {
        return remoteSupportedLanguages
    }

}