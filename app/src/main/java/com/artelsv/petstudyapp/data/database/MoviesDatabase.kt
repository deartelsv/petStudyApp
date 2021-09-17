package com.artelsv.petstudyapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.artelsv.petstudyapp.data.database.dao.MovieDao
import com.artelsv.petstudyapp.data.model.Movie

@Database(entities = [Movie::class], version = 7)
@TypeConverters(DataConverter::class)
abstract class MoviesDatabase : RoomDatabase(){

    abstract fun getMovieDao(): MovieDao
}