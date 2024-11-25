package com.example.data.remote.api

import com.example.data.remote.entity.MultiverseCharacterDetails
import com.example.data.remote.entity.CharactersResponse
import com.example.data.remote.entity.EpisodeDetails
import com.example.data.remote.entity.LocationDetails
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyService {

    @GET("character")
    suspend fun getAllCharacters(): CharactersResponse

    @GET("character/")
    suspend fun getSingleCharacter(@Query("name") name: String): MultiverseCharacterDetails

    @GET
    suspend fun getLocationInfo(@Query("name") locationName: String): LocationDetails

    @GET
    suspend fun getEpisodeInfo(@Query("name") locationName: String): EpisodeDetails
}