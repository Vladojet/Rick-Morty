package com.example.domain.models

data class MultiverseCharacter(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val imageUrl: String,
    val locationName: String,
)
