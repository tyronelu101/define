package com.example.dictionary_loaders

import kotlinx.coroutines.flow.Flow

interface Deserializer<out T> {
    fun deserialize(): Flow<List<T>>
}