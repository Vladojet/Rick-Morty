package com.example.domain.usecases

import com.example.domain.repository.RickAndMortyRepository

class GetSingleCharacterUseCase(private val repository: RickAndMortyRepository) {

    suspend operator fun invoke(characterName: String) {
        repository.getSingleCharacter(characterName)
    }
}