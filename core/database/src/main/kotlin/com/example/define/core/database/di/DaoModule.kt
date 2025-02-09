package com.example.define.core.database.di

import com.example.define.core.database.DefineDatabase
import com.example.define.core.database.daos.DefinitionDao
import com.example.define.core.database.daos.DictionaryDao
import com.example.define.core.database.daos.EntryDao
import com.example.define.core.database.daos.PronunciationDao
import com.example.define.core.database.daos.RecentlySelectedLanguagesDao
import com.example.define.core.database.daos.WordDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DaoModule {

    @Provides
    fun provideDictionaryDao(
        database: DefineDatabase
    ): DictionaryDao = database.dictionaryDao()

    @Provides
    fun provideEntryDao(
        database: DefineDatabase
    ): EntryDao = database.entryDao()

    @Provides
    fun provideWordDao(
        database: DefineDatabase
    ): WordDao = database.wordDao()

    @Provides
    fun providePronunciationDao(
        database: DefineDatabase
    ): PronunciationDao = database.pronunciationDao()

    @Provides
    fun provideDefinitionDao(
        database: DefineDatabase
    ): DefinitionDao = database.definitionDao()

    @Provides
    fun provideRecentlySelectedLanguagesDao(
        database: DefineDatabase
    ): RecentlySelectedLanguagesDao = database.recentlySelectedLanguageDao()

}