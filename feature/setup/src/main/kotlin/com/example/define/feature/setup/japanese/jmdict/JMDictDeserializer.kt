package com.example.define.feature.setup.japanese.jmdict

import com.example.define.feature.setup.JSONDeserializer
import java.io.InputStream

class JMDictDeserializer constructor(
    src: InputStream,
) : JSONDeserializer<JMDictWord>(src) {
    override val range: Pair<Int, Int> = Pair(first = 9, second = 199290)
    override fun getType(): Class<JMDictWord> = JMDictWord::class.java
}