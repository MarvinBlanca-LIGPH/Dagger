package com.example.daggertraining.di

import com.example.daggertraining.data.ApiInterface
import com.example.daggertraining.data.repository.*
import com.example.daggertraining.ui.MainActivity
import dagger.*
import dagger.android.ContributesAndroidInjector
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
abstract class HeroesModule {
    @ContributesAndroidInjector
    abstract fun activity(): MainActivity

    @Binds
    abstract fun bindRepo(impl: HeroesRepositoryImpl?): HeroRepository

    companion object {
        private const val baseUrl = "https://api.opendota.com/api/"

        @Provides
        @Singleton
        fun retrofit(): ApiInterface {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface::class.java)
        }
    }
}