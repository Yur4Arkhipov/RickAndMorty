package com.example.rickandmorty.core.di

import com.example.rickandmorty.core.data.repository.CharacterRepositoryImpl
import com.example.rickandmorty.core.data.repository.CharactersRepositoryImpl
import com.example.rickandmorty.core.database.CharacterDao
import com.example.rickandmorty.core.domain.repository.CharacterRepository
import com.example.rickandmorty.core.domain.repository.CharactersRepository
import com.example.rickandmorty.core.network.service.RickAndMortyApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideCharactersRepository(api: RickAndMortyApiService): CharactersRepository {
        return CharactersRepositoryImpl(api)
    }

    @Provides
    fun provideCharacterRepository(
        api: RickAndMortyApiService,
        dao: CharacterDao
    ): CharacterRepository {
        return CharacterRepositoryImpl(api, dao)
    }
}