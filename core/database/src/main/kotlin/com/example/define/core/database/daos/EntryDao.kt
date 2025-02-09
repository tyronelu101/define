package com.example.define.core.database.daos

import androidx.room.Dao
import androidx.room.Insert
import com.example.define.core.database.entities.EntryEntity

@Dao
interface EntryDao {
    @Insert
    fun insert(entryEntity: EntryEntity): Long
}