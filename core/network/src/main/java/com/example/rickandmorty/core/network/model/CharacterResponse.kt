package com.example.rickandmorty.core.network.model

import com.example.rickandmorty.core.network.dto.CharacterDto
import com.example.rickandmorty.core.network.dto.CharacterInfoDto

data class CharacterResponse(
    val info: CharacterInfoDto,
    val results: List<CharacterDto>
)