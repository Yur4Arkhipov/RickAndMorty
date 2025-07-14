package com.example.rickandmorty.core.domain.repository

import androidx.paging.PagingData
import com.example.rickandmorty.core.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getPagedCharacters(): Flow<PagingData<Character>>
    suspend fun getCharacterById(id: Int): Character
    fun getCharactersPaging(query: String): Flow<PagingData<Character>>
    fun getCharactersPaging(
        name: String?,
        status: String?,
        gender: String?
    ): Flow<PagingData<Character>>
}