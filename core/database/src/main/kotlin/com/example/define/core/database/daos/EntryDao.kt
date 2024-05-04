package com.example.define.core.database.daos

import androidx.room.Dao
import androidx.room.Insert
import com.example.define.core.database.entities.Entry

@Dao
interface EntryDao {
    @Insert
    fun insert(entry: Entry): Long
}