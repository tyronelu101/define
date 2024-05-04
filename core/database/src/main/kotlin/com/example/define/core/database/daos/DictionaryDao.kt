package com.example.define.core.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.define.core.database.entities.Dictionary

@Dao
interface DictionaryDao {
    @Insert
    fun insert(dictionary: Dictionary)

    @Query("SELECT * FROM dictionary WHERE id = :uuid")
    fun get(uuid: String): Dictionary

    @Delete
    fun delete(dictionary: Dictionary)

}