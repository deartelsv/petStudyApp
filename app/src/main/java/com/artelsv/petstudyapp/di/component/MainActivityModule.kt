package com.artelsv.petstudyapp.di.component

import android.app.Application
import com.artelsv.petstudyapp.ui.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(subcomponents = [MainActivitySubcomponent::class])
    abstract class MainActivityModule {
    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)
    abstract fun bindMainActivityInjectorFactory(factory: MainActivitySubcomponent.Factory): AndroidInjector.Factory<MainActivity>
}