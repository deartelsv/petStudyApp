package com.artelsv.petstudyapp.data.repository

import com.artelsv.petstudyapp.data.database.MoviesDatabase
import com.artelsv.petstudyapp.data.network.MoviesService
import com.artelsv.petstudyapp.data.network.model.MovieResponse
import com.artelsv.petstudyapp.domain.MoviesRepository
import io.reactivex.Single
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(val moviesDatabase: MoviesDatabase, private val moviesService: MoviesService) : MoviesRepository {

    override fun getPopularMovies(): Single<MovieResponse> {
        return moviesService.getPopularMovies()
    }

    override fun getNowPlayingMovies(): Single<MovieResponse> {
        return moviesService.getNowPlayingMovies()
    }
}