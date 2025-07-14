package com.example.rickandmorty.core.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.rickandmorty.core.data.CharacterRemoteMediator
import com.example.rickandmorty.core.data.mapper.toDomain
import com.example.rickandmorty.core.data.mapper.toEntity
import com.example.rickandmorty.core.data.paging.CharacterPagingSource
import com.example.rickandmorty.core.database.CharacterDao
import com.example.rickandmorty.core.domain.model.Character
import com.example.rickandmorty.core.domain.repository.CharacterRepository
import com.example.rickandmorty.core.network.service.RickAndMortyApiService
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CharacterRepositoryImpl @Inject constructor(
    private val api: RickAndMortyApiService,
    private val dao: CharacterDao
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

    @OptIn(ExperimentalPagingApi::class)
    override fun getCharactersPaging(query: String): Flow<PagingData<Character>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = CharacterRemoteMediator(api, dao),
            pagingSourceFactory = { dao.getCharactersPaging(query) }
        ).flow.map { pagingData ->
            pagingData.map { it.toDomain() }
        }
    }

//    override suspend fun getCharacterById(id: Int): Character {
//        return api.getCharacterById(id).toDomain()
//    }
    override suspend fun getCharacterById(id: Int): Character {
        val cached = dao.getCharacterById(id)
        return if (cached != null) {
            cached.toDomain()
        } else {
            val response = api.getCharacterById(id)
            dao.insert(response.toEntity())
            response.toDomain()
        }
    }

}
