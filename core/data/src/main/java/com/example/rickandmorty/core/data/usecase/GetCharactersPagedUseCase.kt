package com.example.rickandmorty.core.data.usecase

import androidx.paging.PagingData
import com.example.rickandmorty.core.domain.model.Character
import com.example.rickandmorty.core.domain.repository.CharacterRepository
import com.example.rickandmorty.core.domain.usecase.GetCharactersPagedUseCase
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetCharactersPagedUseCaseImpl @Inject constructor(
    private val repository: CharacterRepository
) : GetCharactersPagedUseCase {

    override fun invoke(query: String): Flow<PagingData<Character>> {
        return repository.getCharactersPaging(query)
    }
}
