package com.artelsv.petstudyapp

import android.app.Application
import com.artelsv.petstudyapp.di.component.DaggerMoviesComponent
import com.artelsv.petstudyapp.di.module.DatabaseModule
import com.artelsv.petstudyapp.di.component.MoviesComponent

class App : Application() {

    companion object {
        lateinit var instance: App
    }

    lateinit var moviesComponent: MoviesComponent

    override fun onCreate() {
        super.onCreate()

        instance = this

        moviesComponent = DaggerMoviesComponent.builder()
            .databaseModule(DatabaseModule(this))
            .build()
    }
}