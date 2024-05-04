package com.example.define.core.database

import android.app.Activity
import android.content.SharedPreferences
import android.os.Bundle
import android.os.PersistableBundle
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.define.core.database.daos.DefinitionDao
import com.example.define.core.database.daos.DictionaryDao
import com.example.define.core.database.daos.EntryDao
import com.example.define.core.database.daos.PronunciationDao
import com.example.define.core.database.daos.WordDao
import com.example.define.core.database.entities.Definition
import com.example.define.core.database.entities.Dictionary
import com.example.define.core.database.entities.Entry
import com.example.define.core.database.entities.Pronunciation
import com.example.define.core.database.entities.Word

@Database(
    entities = [
        Dictionary::class,
        Entry::class,
        Word::class,
        Definition::class,
        Pronunciation::class
    ], version = 1,
    exportSchema = false
)
abstract class DefineDatabase : RoomDatabase() {

    abstract fun dictionaryDao(): DictionaryDao
    abstract fun entryDao(): EntryDao
    abstract fun wordDao(): WordDao
    abstract fun definitionDao(): DefinitionDao
    abstract fun pronunciationDao(): PronunciationDao

}
