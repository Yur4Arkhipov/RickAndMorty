package com.example.rickandmorty.core.network.service

import com.example.rickandmorty.core.network.model.CharacterResponse
import retrofit2.http.GET

interface RickAndMortyApiService {
    @GET("character")
    suspend fun getAllCharacters(): CharacterResponse
}