package com.artelsv.petstudyapp.di.component

import android.content.Context
import com.artelsv.petstudyapp.di.module.DatabaseModule
import com.artelsv.petstudyapp.di.module.MoviesModule
import com.artelsv.petstudyapp.di.module.NetworkModule
import com.artelsv.petstudyapp.ui.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector

@Subcomponent(modules = [MoviesModule::class, NetworkModule::class])
interface MainActivitySubcomponent : AndroidInjector<MainActivity> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<MainActivity> {}
}