package com.example.domain.repository

import com.example.domain.models.MultiverseCharacter
import com.example.domain.models.Episode
import com.example.domain.models.Location

interface RickAndMortyRepository {

    suspend fun getAllCharacters(): List<MultiverseCharacter>

    suspend fun getSingleCharacter(characterName: String): MultiverseCharacter

    suspend fun getLocationInfo(locationName: String): Location

    suspend fun getEpisodeInfo(episodeName: String): Episode
}