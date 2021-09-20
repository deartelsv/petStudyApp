package com.artelsv.petstudyapp.di.module

import androidx.appcompat.app.AppCompatActivity
import com.artelsv.petstudyapp.R
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import dagger.Module
import dagger.Provides

@Module
class NavigatorModule(private val activity: AppCompatActivity) {

    @Provides
    fun provideCicerone(): Cicerone<Router> = Cicerone.create()

    @Provides
    fun provideNavigator(): AppNavigator = AppNavigator(activity, R.id.container)

    @Provides
    fun provideRouter(cicerone: Cicerone<Router>): Router = cicerone.router
}