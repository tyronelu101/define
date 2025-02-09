package com.example.define.core.data.di

import com.example.define.core.data.repository.DefaultDictionaryRepository
import com.example.define.core.data.repository.DefaultDictionarySearchRepo
import com.example.define.core.data.repository.DefaultRecentlySelectedLanguageRepo
import com.example.define.core.data.repository.DefaultSupportedLanguagesRepo
import com.example.define.core.data.repository.DefaultUserPreferencesRepository
import com.example.define.core.data.repository.DictionaryRepository
import com.example.define.core.data.repository.DictionarySearchRepo
import com.example.define.core.data.repository.RecentlySelectedLanguageRepo
import com.example.define.core.data.repository.SupportedLanguagesRepo
import com.example.define.core.data.repository.UserPreferenceRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    internal abstract fun bindDictionaryRepository(dictionaryRepository: DefaultDictionaryRepository): DictionaryRepository

    @Binds
    internal abstract fun bindDictionarySearchRepository(dictionarySearchRepository: DefaultDictionarySearchRepo): DictionarySearchRepo

    @Binds
    internal abstract fun bindSupportedLanguagesRepository(supportedLanguagesRepo: DefaultSupportedLanguagesRepo): SupportedLanguagesRepo

    @Binds
    internal abstract fun bindRecentlySelectedLanguagesRepository(recentlySelectedLanguageRepo: DefaultRecentlySelectedLanguageRepo): RecentlySelectedLanguageRepo

    @Binds
    internal abstract fun bindUserPreferencesRepo(userPreferencesRepository: DefaultUserPreferencesRepository): UserPreferenceRepository

}