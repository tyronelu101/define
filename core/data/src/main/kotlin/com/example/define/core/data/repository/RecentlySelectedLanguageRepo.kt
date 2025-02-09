package com.example.define.core.data.repository

import com.example.define.core.data.models.RecentlySelectedLanguageModel

interface RecentlySelectedLanguageRepo {
    suspend fun insert(selectedLanguage: RecentlySelectedLanguageModel)
    suspend fun getRecentlySelectedLanguages(type: Int): List<RecentlySelectedLanguageModel>
    suspend fun deleteOldestEntry(type: Int)
}