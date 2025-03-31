package com.example.define.core.database.daos.dictionary

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.define.core.database.entities.DefinitionWithDictionary
import com.example.define.core.database.entities.DictionaryEntity
import com.example.define.core.database.entities.DictionaryWithDefinitionsAndPronunciations

@Dao
interface DictionaryDao {
    @Insert
    fun insert(dictionary: DictionaryEntity)

    @Query("SELECT * FROM dictionaryentity WHERE dictionary_id = :uuid")
    fun get(uuid: String): DictionaryEntity

    @Query("SELECT * FROM dictionaryentity")
    fun getAll(): List<DictionaryEntity>

    @Delete
    fun delete(dictionary: DictionaryEntity)

    @Transaction
    @Query("SELECT * from DefinitionEntity where definition_owner_dictionary_id = :dictionaryId")
    fun getDefinitionWithDictionary(dictionaryId: String): DefinitionWithDictionary

    @Transaction
    @Query("SELECT * from DictionaryEntity where dictionary_id = :dictionaryId")
    fun getDictionaryWithDefinitionAndPronunciations(dictionaryId: String): DictionaryWithDefinitionsAndPronunciations

}