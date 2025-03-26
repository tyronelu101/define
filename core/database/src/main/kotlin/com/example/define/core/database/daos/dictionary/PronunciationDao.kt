package com.example.define.core.database.daos.dictionary

import androidx.room.Dao
import androidx.room.Insert
import com.example.define.core.database.entities.PronunciationEntity

@Dao
interface PronunciationDao {
    @Insert
    fun insert(pronunciation: PronunciationEntity): Long

    @Insert
    fun insert(vararg pronunciation: PronunciationEntity): List<Long>
}