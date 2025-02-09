package com.example.define.feature.setup.japanese.jmnedict

import com.example.define.feature.setup.JSONDeserializer
import java.io.InputStream

class JMnedictDeserializer(src: InputStream) : JSONDeserializer<JMnedictWord>(src) {
    override val range: Pair<Int, Int> = Pair(first = 9, second = 742431)
    override fun getType(): Class<JMnedictWord> = JMnedictWord::class.java
}