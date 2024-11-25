package com.example.domain.usecases

import com.example.domain.models.MultiverseCharacter
import com.example.domain.repository.RickAndMortyRepository

class GetAllCharactersUseCase(private val repository: RickAndMortyRepository) {

    suspend operator fun invoke(): List<MultiverseCharacter> {
        return repository.getAllCharacters()

    }
}
