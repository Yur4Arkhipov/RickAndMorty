package com.example.rickandmorty.core.domain.usecase

import androidx.paging.PagingData
import com.example.rickandmorty.core.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface GetPagedCharactersUseCase {
    operator fun invoke(): Flow<PagingData<Character>>
}