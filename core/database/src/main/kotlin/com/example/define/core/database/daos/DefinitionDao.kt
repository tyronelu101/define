package com.example.define.core.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import com.example.define.core.database.entities.Definition

@Dao
interface DefinitionDao {
    @Insert
    fun insert(dictionary: Definition)
    @Delete
    fun delete(dictionary: Definition)
}