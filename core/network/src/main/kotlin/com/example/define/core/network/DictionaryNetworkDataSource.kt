package com.example.define.core.network

import com.example.define.core.network.models.Entry
import kotlinx.coroutines.flow.Flow

interface DictionaryNetworkDataSource {
    suspend fun getEntry(): Flow<List<Entry>>

    suspend fun getLanguages(): List<String>
}