package com.artelsv.petstudyapp.di.component

import com.artelsv.petstudyapp.di.module.DatabaseModule
import com.artelsv.petstudyapp.di.module.MoviesModule
import com.artelsv.petstudyapp.di.module.NetworkModule
import com.artelsv.petstudyapp.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DatabaseModule::class, MoviesModule::class, NetworkModule::class])
interface MoviesComponent {
    fun inject(mainActivity: MainActivity)
}