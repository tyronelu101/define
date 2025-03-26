package com.example.dictionary_loaders.jp.jmdict.models

data class JMdictSense(
//    val antonym: List<Xref>,
    val appliesToKana: List<String>,
    val appliesToKanji: List<String>,
    val dialect: List<String>,
    val field: List<String>,
    val gloss: List<JMdictGloss>,
    val info: List<String>,
//    val languageSource: List<JMdictLanguageSource>,
    val misc: List<String>,
    val partOfSpeech: List<String>,
//    val related: List<Xref>
)