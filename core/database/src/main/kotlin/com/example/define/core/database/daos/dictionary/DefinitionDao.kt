package com.example.define.core.database.daos.dictionary

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.define.core.database.entities.DefinitionEntity
import com.example.define.core.database.entities.DefinitionWithDictionary
import com.example.define.core.database.entities.DefinitionWithDictionaryAndPronunciations


@Dao
interface DefinitionDao {

    @Insert
    fun insert(definition: DefinitionEntity): Long

    @Insert
    fun insert(vararg definitions: DefinitionEntity): List<Long>

    @Query("SELECT * FROM definitionentity WHERE definition_id = :id")
    fun get(id: Long): DefinitionEntity

    @Transaction
    @Query("SELECT * FROM definitionentity WHERE definition_id = :id")
    fun getDefinitionWithDictionary(id: Long): DefinitionWithDictionary

    @Transaction
    @Query("SELECT * FROM definitionentity WHERE definition_id = :id")
    fun getDefinitionWithDictionaryAndPronunciations(id: Long): DefinitionWithDictionaryAndPronunciations

    @Delete
    fun delete(definition: DefinitionEntity)
}