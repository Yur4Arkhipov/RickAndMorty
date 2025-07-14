package com.example.rickandmorty.core.network.dto

data class CharacterInfoDto(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String
)