package com.artelsv.petstudyapp.di.module

import com.artelsv.petstudyapp.data.network.UserService
import com.artelsv.petstudyapp.data.repository.UserRepositoryImpl
import com.artelsv.petstudyapp.domain.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UserModule {

    @Singleton
    @Provides
    fun providesUserRepository(userService: UserService): UserRepository {
        return UserRepositoryImpl(userService)
    }
}