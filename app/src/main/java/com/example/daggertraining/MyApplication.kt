package com.example.daggertraining

import android.app.Application
import com.example.daggertraining.di.DaggerAppComponent
import dagger.android.*
import javax.inject.Inject

class MyApplication : Application(), HasAndroidInjector {
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.create()
            .inject(this)
    }

    override fun androidInjector() = androidInjector
}