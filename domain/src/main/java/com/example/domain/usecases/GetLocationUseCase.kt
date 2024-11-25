package com.example.domain.usecases

import com.example.domain.repository.RickAndMortyRepository

class GetLocationUseCase(private val repository: RickAndMortyRepository) {

    suspend operator fun invoke(locationName: String) {
        repository.getLocationInfo(locationName)
    }
}