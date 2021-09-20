package com.artelsv.petstudyapp.data.database.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.IGNORE
import com.artelsv.petstudyapp.data.entity.MovieEntity
import com.artelsv.petstudyapp.domain.model.Movie

@Dao
interface MovieDao {
    @Insert
    fun addMovie(movie: MovieEntity)

    @Insert(onConflict = IGNORE)
    fun addMovies(movies: List<MovieEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Delete
    fun deleteMovie(movie: MovieEntity)

    @Query("SELECT * FROM movies WHERE movies.id == :position")
    fun getMovieAt(position: Int): MovieEntity

    @Query("SELECT * FROM movies")
    fun getAllMovies(): List<MovieEntity>

    @Query("SELECT * FROM movies ORDER BY movies.voteAverage ASC")
    fun getAllMoviesSortedByVote(): List<MovieEntity>
}