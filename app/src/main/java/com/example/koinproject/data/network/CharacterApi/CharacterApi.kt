package com.example.koinproject.data.network.CharacterApi

import com.example.koinproject.model.CharacterModel
import com.example.koinproject.model.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApi {

    @GET("api/character")
    suspend fun fetchKoin(
        @Query("page") page: Int
    ): RickAndMortyResponse<CharacterModel>
}