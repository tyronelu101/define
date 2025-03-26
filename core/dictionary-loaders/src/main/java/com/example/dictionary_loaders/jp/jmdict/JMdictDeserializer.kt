package com.example.dictionary_loaders.jp.jmdict

import com.example.dictionary_loaders.JSONDeserializer
import com.example.dictionary_loaders.jp.jmdict.models.JMdictWord
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import java.io.InputStream

class JMdictDeserializer(src: InputStream, dispatcher: CoroutineDispatcher = Dispatchers.IO) :
    JSONDeserializer<JMdictWord>(src, dispatcher) {

    override val range: Pair<Int, Int> = Pair(first = 9, second = 199290)
    override val type: Class<JMdictWord> = JMdictWord::class.java
}