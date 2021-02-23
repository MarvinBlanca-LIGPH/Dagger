package com.example.daggertraining.data.repository

import com.example.daggertraining.data.*
import retrofit2.Response
import javax.inject.Inject

class HeroesRepositoryImpl @Inject constructor(
    private val apiInterface: ApiInterface
) : HeroRepository {
    override suspend fun getHeroes(): Response<List<Heroes>> {
        return apiInterface.getHeroes()
    }
}