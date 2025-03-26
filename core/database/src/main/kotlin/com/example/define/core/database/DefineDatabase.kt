package com.example.define.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.define.core.database.converters.InstantConverter
import com.example.define.core.database.daos.dictionary.DefinitionDao
import com.example.define.core.database.daos.dictionary.DictionaryDao
import com.example.define.core.database.daos.dictionary.PronunciationDao
import com.example.define.core.database.daos.RecentlySelectedLanguagesDao
import com.example.define.core.database.daos.dictionary.WordDao
import com.example.define.core.database.entities.DefinitionEntity
import com.example.define.core.database.entities.DictionaryEntity
import com.example.define.core.database.entities.WordDictionaryCrossRef
import com.example.define.core.database.entities.PronunciationEntity
import com.example.define.core.database.entities.RecentlySelectedLanguageEntity
import com.example.define.core.database.entities.WordEntity
import com.example.define.core.database.entities.WordPronunciationDefinitionCrossRef

@Database(
    entities = [
        DictionaryEntity::class,
        WordEntity::class,
        WordDictionaryCrossRef::class,
        DefinitionEntity::class,
        PronunciationEntity::class,
        WordPronunciationDefinitionCrossRef::class,
        RecentlySelectedLanguageEntity::class,
    ], version = 1,
    exportSchema = false
)
@TypeConverters(InstantConverter::class)
abstract class DefineDatabase : RoomDatabase() {
    abstract fun dictionaryDao(): DictionaryDao
    abstract fun wordDao(): WordDao
    abstract fun definitionDao(): DefinitionDao
    abstract fun pronunciationDao(): PronunciationDao

    abstract fun recentlySelectedLanguageDao(): RecentlySelectedLanguagesDao
}
