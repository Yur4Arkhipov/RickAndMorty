package com.example.rickandmorty.core.data.usecase

import com.example.rickandmorty.core.domain.model.Character
import com.example.rickandmorty.core.domain.repository.CharacterRepository
import com.example.rickandmorty.core.domain.usecase.GetCharacterByIdUseCase
import jakarta.inject.Inject

class GetCharacterByIdUseCaseImpl @Inject constructor(
    private val repository: CharacterRepository
) : GetCharacterByIdUseCase {

    override suspend fun invoke(id: Int): Character {
        return repository.getCharacterById(id)
    }
}
