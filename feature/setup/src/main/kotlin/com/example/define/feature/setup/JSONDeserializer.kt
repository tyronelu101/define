package com.example.define.feature.setup

import android.util.Log
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import com.google.gson.Strictness
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

abstract class JSONDeserializer<T>(private val src: InputStream) : Deserializer<T> {

    abstract val range: Pair<Int, Int>
    abstract fun getType(): Class<T>
    override fun deserialize(): List<T> {
        val wordLists = mutableListOf<T>()
        val gson = GsonBuilder().setStrictness(Strictness.LENIENT).create()
        val bufferedReader = BufferedReader(InputStreamReader(src))
        var lines = 0

        try {
            while (bufferedReader.ready()) {
                val line = bufferedReader.readLine()
                ++lines
                if (lines in range.first..range.second) {
                    try {
                        val processedLine = line.substring(0, line.lastIndex)
                        val word = gson.fromJson<T>(
                            processedLine,
                            getType()
                        )
                        wordLists.add(word)
                    } catch (e: JsonSyntaxException) {
                        Log.e(
                            this.javaClass.name,
                            "Failed to deserialize type: ${getType().javaClass}$e"
                        )
                    }
                }
            }
        } catch (e: IOException) {
            Log.e(this.javaClass.name, "Failed to ready buffer reader: $e")

        }

        return wordLists.toList()
    }
}