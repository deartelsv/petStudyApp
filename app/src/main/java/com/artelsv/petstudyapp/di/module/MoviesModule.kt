package com.artelsv.petstudyapp.di.module

import com.artelsv.petstudyapp.data.network.MoviesService
import com.artelsv.petstudyapp.data.repository.MoviesRepositoryImpl
import com.artelsv.petstudyapp.data.database.MoviesDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MoviesModule {

    @Singleton
    @Provides
    fun providesBookRepository(moviesDatabase: MoviesDatabase, moviesService: MoviesService): MoviesRepositoryImpl {
        return MoviesRepositoryImpl(moviesDatabase, moviesService)
    }
}