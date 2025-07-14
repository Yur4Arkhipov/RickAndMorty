package com.example.rickandmorty.core.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rickandmorty.core.data.mapper.toDomain
import com.example.rickandmorty.core.data.paging.CharacterPagingSource
import com.example.rickandmorty.core.domain.model.Character
import com.example.rickandmorty.core.domain.repository.CharacterRepository
import com.example.rickandmorty.core.network.service.RickAndMortyApiService
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow

class CharacterRepositoryImpl @Inject constructor(
    private val api: RickAndMortyApiService
) : CharacterRepository {

    override fun getPagedCharacters(): Flow<PagingData<Character>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { CharacterPagingSource(api) }
        ).flow
    }

    override suspend fun getCharacterById(id: Int): Character {
        return api.getCharacterById(id).toDomain()
    }
}
