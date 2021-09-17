package com.artelsv.petstudyapp.di.module

import com.artelsv.petstudyapp.data.database.MoviesDatabase
import com.artelsv.petstudyapp.data.network.UserService
import com.artelsv.petstudyapp.data.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UserModule {

    @Singleton
    @Provides
    fun providesUserRepository(moviesDatabase: MoviesDatabase, userService: UserService): UserRepositoryImpl {
        return UserRepositoryImpl(moviesDatabase, userService)
    }
}