package com.example.define.core.database.daos

import androidx.room.Dao
import androidx.room.Insert
import com.example.define.core.database.entities.Word


@Dao
interface WordDao {
    @Insert
    fun insert(word: Word)

}