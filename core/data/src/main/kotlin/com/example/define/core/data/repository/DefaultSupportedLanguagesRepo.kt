package com.example.define.core.data.repository

import com.example.define.core.network.DictionaryNetworkDataSource
import javax.inject.Inject

class DefaultSupportedLanguagesRepo @Inject constructor(
    private val dictionaryRepo: DictionaryRepository,
    private val dictionaryNetworkSource: DictionaryNetworkDataSource
) : SupportedLanguagesRepo {

    val languageCodes = listOf(
        "af", // Afrikaans
        "am", // Amharic
        "ar", // Arabic
        "az", // Azerbaijani
        "be", // Belarusian
        "bg", // Bulgarian
        "bn", // Bengali
        "bs", // Bosnian
        "ca", // Catalan
        "cs", // Czech
        "cy", // Welsh
        "da", // Danish
        "de", // German
        "el", // Greek
        "en", // English
        "es", // Spanish
        "et", // Estonian
        "eu", // Basque
        "fa", // Persian
        "fi", // Finnish
        "fr", // French
        "gl", // Galician
        "gu", // Gujarati
        "he", // Hebrew
        "hi", // Hindi
        "hr", // Croatian
        "hu", // Hungarian
        "hy", // Armenian
        "id", // Indonesian
        "is", // Icelandic
        "it", // Italian
        "ja", // Japanese
        "ka", // Georgian
        "kk", // Kazakh
        "km", // Khmer
        "kn", // Kannada
        "ko", // Korean
        "lt", // Lithuanian
        "lv", // Latvian
        "mk", // Macedonian
        "ml", // Malayalam
        "mn", // Mongolian
        "mr", // Marathi
        "ms", // Malay
        "my", // Burmese
        "ne", // Nepali
        "nl", // Dutch
        "no", // Norwegian
        "pl", // Polish
        "pt", // Portuguese
        "ro", // Romanian
        "ru", // Russian
        "si", // Sinhala
        "sk", // Slovak
        "sl", // Slovenian
        "sq", // Albanian
        "sr", // Serbian
        "sv", // Swedish
        "sw", // Swahili
        "ta", // Tamil
        "te", // Telugu
        "th", // Thai
        "tr", // Turkish
        "uk", // Ukrainian
        "ur", // Urdu
        "vi", // Vietnamese
        "zh"  // Chinese
    )

    override suspend fun getSupportedLanguages(): List<String> {
        val localLanguages = dictionaryRepo.getLanguages()
        val networkLanguages = dictionaryNetworkSource.getLanguages()

        return languageCodes
    }
}