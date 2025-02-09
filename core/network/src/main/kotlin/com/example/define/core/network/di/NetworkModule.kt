package com.example.define.core.network.di

import com.example.define.core.network.DictionaryNetworkDataSource
import com.example.define.core.network.FakeDictionaryNetworkDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DictionaryNetworkDataSource() {

    @Binds
    internal abstract fun bindsDictionarySourceRepository(
        dictionaryNetworkDataSource: FakeDictionaryNetworkDataSource
    ): DictionaryNetworkDataSource

}