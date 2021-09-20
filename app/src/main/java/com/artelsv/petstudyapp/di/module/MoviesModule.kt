package com.artelsv.petstudyapp.di.module

import com.artelsv.petstudyapp.data.network.MoviesService
import com.artelsv.petstudyapp.data.repository.MoviesRepositoryImpl
import com.artelsv.petstudyapp.data.database.MoviesDatabase
import com.artelsv.petstudyapp.data.database.dao.MovieDao
import com.artelsv.petstudyapp.domain.MoviesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MoviesModule {

    @Singleton
    @Provides
    fun providesMoviesRepository(moviesDao: MovieDao, moviesService: MoviesService): MoviesRepository {
        return MoviesRepositoryImpl(moviesDao, moviesService)
    }
}