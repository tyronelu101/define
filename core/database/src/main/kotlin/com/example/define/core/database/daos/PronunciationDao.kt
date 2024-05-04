package com.example.define.core.database.daos

import androidx.room.Dao
import androidx.room.Insert
import com.example.define.core.database.entities.Pronunciation

@Dao
interface PronunciationDao {

    @Insert
    fun insert(pronunciation: Pronunciation)

}