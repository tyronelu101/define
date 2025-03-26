package com.example.dictionary_loaders.jp.jmdict.models

data class JMdictKana(
    val appliesToKanji: List<String>,
    val common: Boolean,
    val tags: List<String>,
    val text: String
)