package com.example.define

import com.example.dictionary_loaders.jp.jmdict.JMdictDeserializer
import com.example.dictionary_loaders.jp.jmdict.models.JMdictWord
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import java.io.File

class JMDictDeserializerTest {

    private lateinit var jmdictDeserializer: JMdictDeserializer

    @OptIn(ExperimentalCoroutinesApi::class)
    val dispatcher = UnconfinedTestDispatcher()
    @Before
    fun setup() {
        val jmdictFile: File =
            File(System.getProperty("user.dir")?.plus("/src/test/resources/jmdict-eng-3.6.1.json") ?: "")
        jmdictDeserializer =
            JMdictDeserializer(jmdictFile.inputStream(), dispatcher)
    }

    @Test
    fun test() = runTest(dispatcher) {
        val list = mutableListOf<JMdictWord>()
        var size = 0
        jmdictDeserializer.deserialize().collect {
            size += it.size
            list.addAll(it)
        }

        assert(list.size == 199282)
    }
}