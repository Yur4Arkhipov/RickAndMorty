package com.example.rickandmorty.core.data.usecase

import androidx.paging.PagingData
import com.example.rickandmorty.core.domain.model.Character
import com.example.rickandmorty.core.domain.repository.CharacterRepository
import com.example.rickandmorty.core.domain.usecase.GetPagedCharactersUseCase
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetPagedCharactersUseCaseImpl @Inject constructor(
    private val repository: CharacterRepository
) : GetPagedCharactersUseCase {

    override fun invoke(): Flow<PagingData<Character>> {
        return repository.getPagedCharacters()
    }
}