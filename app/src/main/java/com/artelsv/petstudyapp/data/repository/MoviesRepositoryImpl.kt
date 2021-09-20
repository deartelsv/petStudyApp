package com.artelsv.petstudyapp.data.repository

import android.util.Log
import com.artelsv.petstudyapp.data.database.dao.MovieDao
import com.artelsv.petstudyapp.data.mappers.MovieMapper
import com.artelsv.petstudyapp.data.network.MoviesService
import com.artelsv.petstudyapp.data.network.model.MovieResponse
import com.artelsv.petstudyapp.domain.MoviesRepository
import com.artelsv.petstudyapp.domain.model.MovieType
import io.reactivex.Single
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(val moviesDatabase: MoviesDatabase, private val moviesService: MoviesService) : MoviesRepository {

    override fun getPopularMovies(): Single<MovieResponse> {
        return moviesService.getPopularMovies().map {
            addMoviesToDb(it, MovieType.POPULAR)
        }
    }

    override fun getNowPlayingMovies(): Single<MovieResponse> {
        return moviesService.getNowPlayingMovies().map {
            addMoviesToDb(it, MovieType.NOW_PLAYING)
        }
    }

    private fun addMoviesToDb(data: MovieResponse, type: MovieType) : MovieResponse {
        val mapper = MovieMapper(type)

        movieDao.addMovies(mapper.toListMovieEntity(data.results))

        return data
    }
}