package com.example.define.feature.setup.japanese.jmnedict


data class JMnedictWord(val id: String)

data class JMnedictKana(val kana: String)

data class JMnedictKanji(val text: String)

data class JMnedictTranslation(val text: String)

data class JMnedictTranslations(val translation: List<JMnedictTranslation>)