package com.example.rickandmorty.core.di

import com.example.rickandmorty.core.data.usecase.GetCharacterByIdUseCaseImpl
import com.example.rickandmorty.core.data.usecase.GetCharactersPagedUseCaseImpl
import com.example.rickandmorty.core.data.usecase.GetCharactersPagingUseCaseImpl
import com.example.rickandmorty.core.data.usecase.GetCharactersUseCaseImpl
import com.example.rickandmorty.core.data.usecase.GetPagedCharactersUseCaseImpl
import com.example.rickandmorty.core.domain.repository.CharacterRepository
import com.example.rickandmorty.core.domain.repository.CharactersRepository
import com.example.rickandmorty.core.domain.usecase.GetCharacterByIdUseCase
import com.example.rickandmorty.core.domain.usecase.GetCharactersPagedUseCase
import com.example.rickandmorty.core.domain.usecase.GetCharactersPagingUseCase
import com.example.rickandmorty.core.domain.usecase.GetCharactersUseCase
import com.example.rickandmorty.core.domain.usecase.GetPagedCharactersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun provideGetCharactersUseCase(
        repository: CharactersRepository
    ): GetCharactersUseCase {
        return GetCharactersUseCaseImpl(repository)
    }

    @Provides
    fun provideGetPagedCharactersUseCase(
        repository: CharacterRepository
    ): GetPagedCharactersUseCase {
        return GetPagedCharactersUseCaseImpl(repository)
    }

    @Provides
    fun provideGetCharacterByIdUseCase(
        repository: CharacterRepository
    ): GetCharacterByIdUseCase {
        return GetCharacterByIdUseCaseImpl(repository)
    }

    @Provides
    fun provideGetCharactersPagedUseCase(
        repository: CharacterRepository
    ): GetCharactersPagedUseCase {
        return GetCharactersPagedUseCaseImpl(repository)
    }

    @Provides
    fun provideGetCharactersPagingUseCase(
        repository: CharacterRepository
    ): GetCharactersPagingUseCase {
        return GetCharactersPagingUseCaseImpl(repository)
    }

}