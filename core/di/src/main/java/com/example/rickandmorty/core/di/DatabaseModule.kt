package com.example.rickandmorty.core.di

import android.content.Context
import androidx.room.Room
import com.example.rickandmorty.core.database.AppDatabase
import com.example.rickandmorty.core.database.CharacterDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlin.jvm.java

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "AppDatabase"
        ).build()
    }

    @Provides
    fun provideBinQueryDao(database: AppDatabase): CharacterDao {
        return database.characterDao()
    }
}