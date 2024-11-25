package com.example.domain.usecases

import com.example.domain.models.Episode
import com.example.domain.repository.RickAndMortyRepository

class GetEpisodeUseCase(private val repository: RickAndMortyRepository) {

    suspend operator fun invoke(episodeName: String): Episode {
        return repository.getEpisodeInfo(episodeName)
    }
}