package com.example.rickandmorty.di

import com.example.data.repository.RickAndMortyRepositoryImpl
import com.example.domain.repository.RickAndMortyRepository
import com.example.domain.usecases.GetAllCharactersUseCase
import com.example.domain.usecases.GetEpisodeUseCase
import com.example.domain.usecases.GetLocationUseCase
import com.example.domain.usecases.GetSingleCharacterUseCase
import org.koin.dsl.module

val domainModule = module {
    single<RickAndMortyRepository> { get<RickAndMortyRepositoryImpl>() }

    factory { GetEpisodeUseCase(get()) }
    factory { GetLocationUseCase(get()) }
    factory { GetAllCharactersUseCase(get()) }
    factory { GetSingleCharacterUseCase(get()) }
}