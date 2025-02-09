package com.example.define.core.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.define.core.database.entities.DictionaryEntity

@Dao
interface DictionaryDao {
    @Insert
    fun insert(dictionaryEntity: DictionaryEntity)

    @Query("SELECT * FROM dictionaryentity WHERE uuid = :uuid")
    fun get(uuid: String): DictionaryEntity

    @Delete
    fun delete(dictionaryEntity: DictionaryEntity)

}