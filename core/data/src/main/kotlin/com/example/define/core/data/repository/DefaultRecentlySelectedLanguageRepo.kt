package com.example.define.core.data.repository

import com.example.define.core.database.daos.RecentlySelectedLanguagesDao
import com.example.define.core.data.models.RecentlySelectedLanguageModel
import com.example.define.core.data.models.toEntity
import com.example.define.core.data.models.toModel
import kotlinx.datetime.Instant
import javax.inject.Inject

class DefaultRecentlySelectedLanguageRepo @Inject constructor(private val dao: RecentlySelectedLanguagesDao) :
    RecentlySelectedLanguageRepo {
    override suspend fun insert(selectedLanguage: RecentlySelectedLanguageModel) {
        dao.insert(selectedLanguage.toEntity())
    }

    override suspend fun getRecentlySelectedLanguages(type: Int): List<RecentlySelectedLanguageModel> {
//        val entities = dao.getRecentlySelectedLanguages(type)
//        return entities.map { it.toModel() }
        val languageCodes = listOf("en", "es", "fr", "de", "ja")

        return languageCodes.map {
            RecentlySelectedLanguageModel(
                type = 0,
                it,
                Instant.fromEpochMilliseconds(0)
            )
        }
    }

    override suspend fun deleteOldestEntry(type: Int) {
        val oldestEntry = dao.getOldestEntry(type)
        dao.delete(oldestEntry)
    }
}