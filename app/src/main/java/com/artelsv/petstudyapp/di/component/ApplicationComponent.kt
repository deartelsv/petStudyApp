package com.artelsv.petstudyapp.di.component

import android.app.Application
import com.artelsv.petstudyapp.di.module.ContextModule
import com.artelsv.petstudyapp.di.module.DatabaseModule
import com.artelsv.petstudyapp.ui.MainActivity
import dagger.Component

@Component(modules = [DatabaseModule::class, ContextModule::class, MainActivityModule::class])
// честно скажу - я намучился, но не доделал)
interface ApplicationComponent {
    fun inject(application: Application)
}