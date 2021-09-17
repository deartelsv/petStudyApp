package com.artelsv.petstudyapp.data.database.dao

import androidx.room.*
import com.artelsv.petstudyapp.data.model.Movie

@Dao
interface MovieDao {
    @Insert
    fun addMovie(movie: Movie)

    @Insert
    fun addMovies(movies: List<Movie>)

    @Update
    fun updateMovie(movie: Movie)

//    @Update
//    fun updateMovie(position: Int)

    @Delete
    fun deleteMovie(movie: Movie)

//    @Delete
//    fun deleteMovie(position: Int)

    @Query("SELECT * FROM movies WHERE movies.uid == :position")
    fun getMovieAt(position: Int): Movie

    @Query("SELECT * FROM movies")
    fun getAllMovies(): List<Movie>
}