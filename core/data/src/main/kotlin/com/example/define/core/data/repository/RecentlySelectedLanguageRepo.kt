package com.example.define.core.data.repository

import com.example.define.core.data.models.RecentlySelectedLanguageModel
import com.example.define.core.models.LanguageSelectionType

interface RecentlySelectedLanguageRepo {
    suspend fun insert(selectedLanguage: RecentlySelectedLanguageModel)
    suspend fun getRecentlySelectedLanguages(type: LanguageSelectionType): List<RecentlySelectedLanguageModel>
    suspend fun deleteOldestEntry(type: Int)
}