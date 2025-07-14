package com.example.rickandmorty.core.domain.usecase

import com.example.rickandmorty.core.domain.model.Character

interface GetCharacterByIdUseCase {
    suspend operator fun invoke(id: Int): Character
}