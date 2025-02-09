package com.example.define.core.database.di

import android.content.Context
import androidx.room.Room
import com.example.define.core.database.DefineDatabase
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {
    @Provides
    @Singleton
    fun provideDefineDatabase(@ApplicationContext context: Context): DefineDatabase =
        Room.databaseBuilder(
            context, DefineDatabase::class.java,
            "nia-database",
        ).build()
}