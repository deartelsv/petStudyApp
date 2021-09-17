package com.artelsv.petstudyapp.data.repository

import com.artelsv.petstudyapp.data.network.MoviesService
import com.artelsv.petstudyapp.data.database.MoviesDatabase
import com.artelsv.petstudyapp.domain.MoviesRepository
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(private val moviesDatabase: MoviesDatabase, private val moviesService: MoviesService) : MoviesRepository {

    override fun getMovies() {
        val dis = moviesService.getPopularMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe({ response ->
                moviesDatabase.getMovieDao().addMovies(response.results)
        }, { error ->

        })
    }
}