package com.example.define.feature.setup.japanese.kanjidict

data class KanjiDictWord(
    val literal: String,
    val readingMeaning: List<KanjiDictMeaningReading>,
    val misc: KanjiDictMisc
)

data class KanjiDictMeaningReading(
    val groups: List<KanjiDictReadingMeaningGroup>
)

data class KanjiDictReadingMeaningGroup(
    val meanings: List<KanjiDictMeaning>,
    val readings: List<KanjiDictReading>
)

data class KanjiDictMeaning(val value: String)

data class KanjiDictMisc(val jlptLevel: String?, val strokeCount: List<Int>)

data class KanjiDictReading(val value: String)

