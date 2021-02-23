package com.example.daggertraining.data

import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("heroes")
    suspend fun getHeroes(): Response<List<Heroes>>
}