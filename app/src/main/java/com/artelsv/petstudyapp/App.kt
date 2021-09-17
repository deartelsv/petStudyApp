package com.artelsv.petstudyapp

import android.app.Application
import com.artelsv.petstudyapp.di.component.DaggerMoviesComponent
import com.artelsv.petstudyapp.di.module.DatabaseModule
import com.artelsv.petstudyapp.di.component.MoviesComponent
import com.github.terrakok.cicerone.Cicerone

class App : Application() {

    companion object {
        lateinit var instance: App
    }

    lateinit var moviesComponent: MoviesComponent

    // cicerone
    private val cicerone = Cicerone.create()
    val router
        get() = cicerone.router
    val navigatorHolder
        get() = cicerone.getNavigatorHolder()

    override fun onCreate() {
        super.onCreate()

        instance = this

        moviesComponent = DaggerMoviesComponent.builder()
            .databaseModule(DatabaseModule(this))
            .build()
    }
}