package com.artelsv.petstudyapp.data.network

import com.artelsv.petstudyapp.data.network.model.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import java.util.concurrent.Callable

const val API_KEY = "2807255081825272abadbf4e147ca188"
const val DEFAULT_LANG = "en-US"

interface MoviesService {

    @GET("movie/popular?page=1")
    fun getPopularMovies() : Single<MovieResponse>

    @GET("movie/now_playing?page=1")
    fun getNowPlayingMovies() : Single<MovieResponse>
}