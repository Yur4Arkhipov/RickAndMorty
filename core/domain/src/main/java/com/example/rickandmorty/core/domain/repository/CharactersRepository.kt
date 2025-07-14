package com.example.rickandmorty.core.domain.repository

import com.example.rickandmorty.core.domain.model.Character

interface CharactersRepository {
    suspend fun getCharacters(): List<Character>
}