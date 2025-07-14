package com.example.rickandmorty.core.domain.usecase

import androidx.paging.PagingData
import com.example.rickandmorty.core.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface GetCharactersPagingUseCase {
    operator fun invoke(
        name: String?,
        status: String?,
        gender: String?
    ): Flow<PagingData<Character>>
}
