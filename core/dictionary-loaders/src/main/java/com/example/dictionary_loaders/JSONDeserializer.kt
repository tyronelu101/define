package com.example.dictionary_loaders

import com.google.gson.GsonBuilder
import com.google.gson.Strictness
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

abstract class JSONDeserializer<T>(
    private val src: InputStream,
    private val dispatcher: CoroutineDispatcher
) : Deserializer<T> {

    private val BUFFER_SIZE = 1000
    abstract val range: Pair<Int, Int>
    abstract val type: Class<T>
    override fun deserialize(): Flow<List<T>> = flow {
        val wordLists = mutableListOf<T>()
        val gson = GsonBuilder().apply {
            setStrictness(Strictness.LENIENT)
        }.create()
        val bufferedReader = BufferedReader(InputStreamReader(src))
        var lines = 0
        var line: String
        while (bufferedReader.readLine().also{line = it} != null) {
            ++lines
            if (lines in range.first..range.second) {
                val processedLine = line.substring(0, line.lastIndex)
                val word = gson.fromJson(processedLine, type)

                if (word != null) {
                    wordLists.add(word)
                }

                if (wordLists.size >= BUFFER_SIZE) {
                    emit(wordLists)
                    wordLists.clear()
                }
            }
        }
        if (wordLists.isNotEmpty()) {
            emit(wordLists)
        }
    }.flowOn(dispatcher).catch { e ->
//        Log.e(this.javaClass.name, "Failed to ready buffer reader: $e")
    }
}