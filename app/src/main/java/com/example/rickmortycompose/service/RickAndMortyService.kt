package com.example.rickmortycompose.service

import com.example.rickmortycompose.models.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET

interface RickAndMortyService{
    @GET("character")
    suspend fun getCharacter():Response<CharacterResponse>
}