package com.artelsv.petstudyapp.domain

import com.artelsv.petstudyapp.data.network.model.MovieResponse
import io.reactivex.Single

interface MoviesRepository {

    fun getMovies() : Single<MovieResponse>
}