package com.example.daggertraining.di

import com.example.daggertraining.MyApplication
import dagger.Component
import dagger.android.*
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        HeroesModule::class
    ]
)
interface AppComponent : AndroidInjector<MyApplication>