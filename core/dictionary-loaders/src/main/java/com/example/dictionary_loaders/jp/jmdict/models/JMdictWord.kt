package com.example.dictionary_loaders.jp.jmdict.models

data class JMdictWord(
    val id: String,
    val kanas: List<JMdictKana>,
    val kanjis: List<JMdictKanji>,
    val senses: List<JMdictSense>
)