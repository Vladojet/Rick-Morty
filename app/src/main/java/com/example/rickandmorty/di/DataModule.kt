package com.example.rickandmorty.di

import com.example.data.remote.api.RickAndMortyService
import com.example.data.repository.RickAndMortyRepositoryImpl
import com.example.domain.repository.RickAndMortyRepository
import org.koin.core.scope.get
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single<RickAndMortyService> {
        get<Retrofit>().create(RickAndMortyService::class.java)
    }
    single<RickAndMortyRepository> {
        RickAndMortyRepositoryImpl(get())
    }
}