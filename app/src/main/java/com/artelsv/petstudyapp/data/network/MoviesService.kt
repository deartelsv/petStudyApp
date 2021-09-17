package com.artelsv.petstudyapp.data.network

import com.artelsv.petstudyapp.data.network.model.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET

interface MoviesService {

    @GET("movie/popular?api_key=2807255081825272abadbf4e147ca188&language=en-US&page=1")
    fun getPopularMovies() : Single<MovieResponse>
}