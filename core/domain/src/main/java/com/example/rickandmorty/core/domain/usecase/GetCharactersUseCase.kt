package com.example.rickandmorty.core.domain.usecase

import com.example.rickandmorty.core.domain.model.Character

interface GetCharactersUseCase {
    suspend operator fun invoke(): List<Character>
}