package com.example.daggertraining.data.repository

import com.example.daggertraining.data.Heroes
import retrofit2.Response

interface HeroRepository {
    suspend fun getHeroes(): Response<List<Heroes>>
}