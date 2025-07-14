package com.example.rickandmorty.core.data.usecase

import androidx.paging.PagingData
import com.example.rickandmorty.core.domain.model.Character
import com.example.rickandmorty.core.domain.repository.CharacterRepository
import com.example.rickandmorty.core.domain.usecase.GetCharactersPagingUseCase
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetCharactersPagingUseCaseImpl @Inject constructor(
    private val repository: CharacterRepository
) : GetCharactersPagingUseCase {

    override fun invoke(
        name: String?,
        status: String?,
        gender: String?
    ): Flow<PagingData<Character>> {
        return repository.getCharactersPaging(name, status, gender)
    }
}
