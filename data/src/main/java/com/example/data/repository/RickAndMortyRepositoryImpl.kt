package com.example.data.repository

import com.example.data.remote.api.RickAndMortyService
import com.example.data.remote.entity.MultiverseCharacterDetails.Companion.mapToCharacter
import com.example.data.remote.entity.EpisodeDetails.Companion.mapToEpisode
import com.example.data.remote.entity.LocationDetails.Companion.mapToLocation
import com.example.domain.models.Episode
import com.example.domain.models.Location
import com.example.domain.repository.RickAndMortyRepository

class RickAndMortyRepositoryImpl(
    private val apiService: RickAndMortyService
) : RickAndMortyRepository {

    override suspend fun getAllCharacters(): List<Character> {
        val response = apiService.getAllCharacters()
        return response.results.map { it.mapToCharacter() }
    }

    override suspend fun getSingleCharacter(characterName: String): Character {
        val response = apiService.getSingleCharacter(characterName)
        return response.mapToCharacter()
    }

    override suspend fun getLocationInfo(locationName: String): Location {
        val response = apiService.getLocationInfo(locationName)
        return response.mapToLocation()
    }

    override suspend fun getEpisodeInfo(episodeName: String): Episode {
        val response = apiService.getEpisodeInfo(episodeName)
        return response.mapToEpisode()
    }
}