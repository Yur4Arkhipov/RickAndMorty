package com.example.rickandmorty.core.data

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.example.rickandmorty.core.data.mapper.toEntity
import com.example.rickandmorty.core.database.CharacterDao
import com.example.rickandmorty.core.database.CharacterEntity
import com.example.rickandmorty.core.network.service.RickAndMortyApiService

@OptIn(ExperimentalPagingApi::class)
class CharacterRemoteMediator(
    private val api: RickAndMortyApiService,
    private val dao: CharacterDao
) : RemoteMediator<Int, CharacterEntity>() {

    private var currentPage = 1

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, CharacterEntity>
    ): MediatorResult {
        return try {
            val page = when (loadType) {
                LoadType.REFRESH -> {
                    currentPage = 1
                    currentPage
                }
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> currentPage + 1
            }

            val response = api.getCharactersByPage(page)
            val characters = response.results.map { it.toEntity() }

            dao.run {
                if (loadType == LoadType.REFRESH) {
                    clearAll()
                }
                insertAll(characters)
            }

            currentPage = page

            val endReached = false
            MediatorResult.Success(endOfPaginationReached = endReached)

        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }
}