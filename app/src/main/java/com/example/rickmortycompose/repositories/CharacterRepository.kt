package com.example.rickmortycompose.repositories

import com.example.rickmortycompose.models.Character
import com.example.rickmortycompose.service.RickAndMortyService
import com.example.rickmortycompose.util.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CharacterRepository {
    private val service: RickAndMortyService by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RickAndMortyService::class.java)

    }

    suspend fun getCharacters():List<Character>{
        return service.getCharacter().body()?.results?: emptyList()
    }
}