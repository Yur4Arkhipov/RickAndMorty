package com.example.rickandmorty.core.data.mapper

import com.example.rickandmorty.core.database.CharacterEntity
import com.example.rickandmorty.core.network.dto.CharacterDto

fun CharacterDto.toEntity(): CharacterEntity = CharacterEntity(
    id = id,
    name = name,
    status = status,
    species = species,
    type = type,
    gender = gender,
    originName = origin.name,
    originUrl = origin.url,
    locationName = location.name,
    locationUrl = location.url,
    image = image,
    episode = episode,
    url = url,
    created = created
)
