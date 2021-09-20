package com.artelsv.petstudyapp.di.component

import com.artelsv.petstudyapp.di.module.*
import com.artelsv.petstudyapp.ui.MainActivity
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import javax.inject.Singleton

////TODO почитай про Dagger & Android  https://dagger.dev/dev-guide/android.html
@Singleton
@Component(modules = [DatabaseModule::class, MoviesModule::class, NetworkModule::class])
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
//    fun provideCicerone(): Cicerone<Router>
//    fun router(): Router
}



