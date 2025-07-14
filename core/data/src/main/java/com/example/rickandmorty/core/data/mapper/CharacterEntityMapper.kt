package com.example.rickandmorty.core.data.mapper

import com.example.rickandmorty.core.database.CharacterEntity
import com.example.rickandmorty.core.domain.model.Character

fun CharacterEntity.toDomain(): Character {
    return Character(
        id = id,
        name = name,
        status = status,
        species = species,
        type = type,
        gender = gender,
        originName = originName,
        originUrl = originUrl,
        locationName = locationName,
        locationUrl = locationUrl,
        image = image,
        episode = episode,
        url = url,
        created = created
    )
}
