package com.example.define.core.database.di

import com.example.define.core.database.DefineDatabase
import com.example.define.core.database.daos.dictionary.DefinitionDao
import com.example.define.core.database.daos.dictionary.DictionaryDao
import com.example.define.core.database.daos.dictionary.PronunciationDao
import com.example.define.core.database.daos.RecentlySelectedLanguagesDao
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