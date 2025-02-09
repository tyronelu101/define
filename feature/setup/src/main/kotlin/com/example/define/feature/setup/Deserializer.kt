package com.example.define.feature.setup

interface Deserializer<out T> {
    fun deserialize(): List<T>
}