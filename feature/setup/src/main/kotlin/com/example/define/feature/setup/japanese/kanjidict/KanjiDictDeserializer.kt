package com.example.define.feature.setup.japanese.kanjidict

import com.example.define.feature.setup.JSONDeserializer
import java.io.InputStream

class KanjiDictDeserializer(src: InputStream) : JSONDeserializer<KanjiDictWord>(src) {
    override val range: Pair<Int, Int> = Pair(first = 8, second = 10390)
    override fun getType(): Class<KanjiDictWord> = KanjiDictWord::class.java
}