package com.example.define.core.network

import com.example.define.core.network.models.Entry
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FakeDictionaryNetworkDataSource @Inject constructor() : DictionaryNetworkDataSource {
    override suspend fun getEntry(): Flow<List<Entry>> {
        return flow {}
    }

    override suspend fun getLanguages(): List<String> {
        return listOf("BZ", "NET1", "NET2")
    }

}