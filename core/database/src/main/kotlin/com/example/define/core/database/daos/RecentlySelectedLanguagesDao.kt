package com.example.define.core.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.define.core.database.entities.DictionaryEntity
import com.example.define.core.database.entities.RecentlySelectedLanguageEntity

@Dao
interface RecentlySelectedLanguagesDao {

    @Insert
    fun insert(language: RecentlySelectedLanguageEntity)

    @Query("SELECT * FROM recentlyselectedlanguageentity WHERE type = :type and langCode = :langCode")
    fun get(type: Int, langCode: String): RecentlySelectedLanguageEntity

    @Query("SELECT * FROM recentlyselectedlanguageentity WHERE type = :type ORDER BY langCode ASC")
    fun getRecentlySelectedLanguages(type: Int): List<RecentlySelectedLanguageEntity>

    @Query("SELECT * FROM recentlyselectedlanguageentity WHERE type = :type ORDER BY insertedDate DESC")
    fun getOldestEntry(type: Int): RecentlySelectedLanguageEntity

    @Delete
    fun delete(language: RecentlySelectedLanguageEntity)
}