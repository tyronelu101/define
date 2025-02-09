package com.example.define.feature.setup.japanese.jmdict


data class JMDictWord(
    val id: String,
    val kanji: List<Kanji>,
    val kana: List<Kana>,
    val sense: List<Sense>
)

data class Kana(
    val text: String,
)

data class Kanji(
    val text: String,
    val tags: List<Tag>
)

data class Sense(
    val partOfSpeech: List<String>,
)

data class Tag(val text: String)