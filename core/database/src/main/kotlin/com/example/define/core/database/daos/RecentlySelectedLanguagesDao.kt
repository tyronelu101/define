package com.example.define.core.database.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.define.core.database.entities.RecentlySelectedLanguageEntity

@Dao
interface RecentlySelectedLanguagesDao {

    @Upsert
    fun insert(language: RecentlySelectedLanguageEntity)

    @Query("SELECT * FROM recentlyselectedlanguageentity WHERE type = :type and langCode = :langCode")
    fun get(type: Int, langCode: String): RecentlySelectedLanguageEntity

    @Query("SELECT * FROM recentlyselectedlanguageentity WHERE type = :type ORDER BY langCode ASC")
    fun getRecentlySelectedLanguages(type: Int): List<RecentlySelectedLanguageEntity>

    @Query("SELECT * FROM recentlyselectedlanguageentity WHERE type = :type ORDER BY insertedDate DESC")
    fun getOldestEntry(type: Int): RecentlySelectedLanguageEntity


}