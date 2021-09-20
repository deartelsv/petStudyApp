package com.artelsv.petstudyapp

import android.app.Application
import com.artelsv.petstudyapp.di.component.*
import com.artelsv.petstudyapp.di.module.DatabaseModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


class App : Application(), HasAndroidInjector {

    companion object {
        lateinit var instance: App
    }

    lateinit var mainActivityComponent: MainActivityComponent
    lateinit var authComponent: AuthComponent

    // cicerone
//    private val cicerone = Cicerone.create()
//    val router
//        get() = cicerone.router
//    val navigatorHolder
//        get() = cicerone.getNavigatorHolder()

    override fun onCreate() {
        super.onCreate()

        instance = this
//
        mainActivityComponent = DaggerMainActivityComponent.builder()
            .databaseModule(DatabaseModule(this))
//            .navigatorModule(NavigatorModule())
            .build()
//
        authComponent = DaggerAuthComponent.builder().build()

//        DaggerApplicationComponent.create().inject(this)

        DaggerApplicationComponent.create()
            .inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }
}