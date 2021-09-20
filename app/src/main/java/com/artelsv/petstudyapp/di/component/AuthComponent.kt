package com.artelsv.petstudyapp.di.component

import com.artelsv.petstudyapp.di.module.NavigatorModule
import com.artelsv.petstudyapp.di.module.NetworkModule
import com.artelsv.petstudyapp.di.module.UserModule
import com.artelsv.petstudyapp.ui.AuthActivity
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, UserModule::class])
interface AuthComponent {
    fun inject(authActivity: AuthActivity)
//    fun provideCicerone(): Cicerone<Router>
//    fun router(): Router
}