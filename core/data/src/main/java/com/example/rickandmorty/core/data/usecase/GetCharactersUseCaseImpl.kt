package com.example.rickandmorty.core.data.usecase

import com.example.rickandmorty.core.domain.model.Character
import com.example.rickandmorty.core.domain.repository.CharactersRepository
import com.example.rickandmorty.core.domain.usecase.GetCharactersUseCase
import jakarta.inject.Inject

class GetCharactersUseCaseImpl @Inject constructor(
    private val repository: CharactersRepository
) : GetCharactersUseCase {

    override suspend fun invoke(): List<Character> {
        return repository.getCharacters()
    }
}