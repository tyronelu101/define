package com.example.dictionary_loaders.jp.jmdict.models

// JMdictKanji data class
data class JMdictKanji(
    val common: Boolean,
    val tags: List<String>,
    val text: String
)