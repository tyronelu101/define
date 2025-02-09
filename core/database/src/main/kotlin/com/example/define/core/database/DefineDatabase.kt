package com.example.define.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.define.core.database.converters.InstantConverter
import com.example.define.core.database.daos.DefinitionDao
import com.example.define.core.database.daos.DictionaryDao
import com.example.define.core.database.daos.EntryDao
import com.example.define.core.database.daos.PronunciationDao
import com.example.define.core.database.daos.RecentlySelectedLanguagesDao
import com.example.define.core.database.daos.WordDao
import com.example.define.core.database.entities.DefinitionEntity
import com.example.define.core.database.entities.DictionaryEntity
import com.example.define.core.database.entities.EntryEntity
import com.example.define.core.database.entities.PronunciationEntity
import com.example.define.core.database.entities.RecentlySelectedLanguageEntity
import com.example.define.core.database.entities.WordEntity

@Database(
    entities = [
        DictionaryEntity::class,
        EntryEntity::class,
        WordEntity::class,
        DefinitionEntity::class,
        PronunciationEntity::class,
        RecentlySelectedLanguageEntity::class
    ], version = 1,
    exportSchema = false
)
@TypeConverters(InstantConverter::class)
abstract class DefineDatabase : RoomDatabase() {
    abstract fun dictionaryDao(): DictionaryDao
    abstract fun entryDao(): EntryDao
    abstract fun wordDao(): WordDao
    abstract fun definitionDao(): DefinitionDao
    abstract fun pronunciationDao(): PronunciationDao

    abstract fun recentlySelectedLanguageDao(): RecentlySelectedLanguagesDao
}
