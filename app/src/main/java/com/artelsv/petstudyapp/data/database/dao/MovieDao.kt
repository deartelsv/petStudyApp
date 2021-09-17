package com.artelsv.petstudyapp.data.database.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.IGNORE
import com.artelsv.petstudyapp.data.model.Movie

@Dao
interface MovieDao {
    @Insert
    fun addMovie(movie: Movie)

    @Insert(onConflict = IGNORE)
    fun addMovies(movies: List<Movie>)

    @Update
    fun updateMovie(movie: Movie)

//    @Update
//    fun updateMovie(position: Int)

    @Delete
    fun deleteMovie(movie: Movie)

//    @Delete
//    fun deleteMovie(position: Int)

    @Query("SELECT * FROM movies WHERE movies.id == :position")
    fun getMovieAt(position: Int): Movie

    @Query("SELECT * FROM movies")
    fun getAllMovies(): List<Movie>

    @Query("SELECT * FROM movies ORDER BY movies.voteAverage ASC")
    fun getAllMoviesSortedByVote(): List<Movie>
}