package com.example.rickandmorty.core.network.service

import com.example.rickandmorty.core.network.dto.CharacterDto
import com.example.rickandmorty.core.network.model.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyApiService {
    @GET("character")
    suspend fun getAllCharacters(): CharacterResponse

    @GET("character")
    suspend fun getCharactersByPage(
        @Query("page") page: Int
    ): CharacterResponse

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): CharacterDto
}