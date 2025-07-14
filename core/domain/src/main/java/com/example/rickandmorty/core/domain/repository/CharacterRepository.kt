package com.example.rickandmorty.core.domain.repository

import androidx.paging.PagingData
import com.example.rickandmorty.core.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getPagedCharacters(): Flow<PagingData<Character>>
}