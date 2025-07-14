package com.example.rickandmorty.core.data.repository

import com.example.rickandmorty.core.data.mapper.toDomain
import com.example.rickandmorty.core.domain.model.Character
import com.example.rickandmorty.core.domain.repository.CharactersRepository
import com.example.rickandmorty.core.network.service.RickAndMortyApiService
import jakarta.inject.Inject

class CharactersRepositoryImpl @Inject constructor(
    private val api: RickAndMortyApiService
) : CharactersRepository {

    override suspend fun getCharacters(): List<Character> {
        return api.getAllCharacters().results.map { it.toDomain() }
    }
}