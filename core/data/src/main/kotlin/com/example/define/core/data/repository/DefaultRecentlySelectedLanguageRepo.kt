package com.example.define.core.data.repository

import com.example.define.core.data.models.RecentlySelectedLanguageModel
import com.example.define.core.data.models.toEntity
import com.example.define.core.data.models.toModel
import com.example.define.core.database.daos.RecentlySelectedLanguagesDao
import com.example.define.core.models.LanguageSelectionType
import javax.inject.Inject

class DefaultRecentlySelectedLanguageRepo @Inject constructor(private val dao: RecentlySelectedLanguagesDao) :
    RecentlySelectedLanguageRepo {
    override suspend fun insert(selectedLanguage: RecentlySelectedLanguageModel) {
        dao.insert(selectedLanguage.toEntity())
    }

    override suspend fun getRecentlySelectedLanguages(type: LanguageSelectionType): List<RecentlySelectedLanguageModel> {
        val entities = dao.getRecentlySelectedLanguages(type.ordinal)
        return entities.map { it.toModel() }
    }

    override suspend fun deleteOldestEntry(type: Int) {
        val oldestEntry = dao.getOldestEntry(type)
        dao.delete(oldestEntry)
    }
}