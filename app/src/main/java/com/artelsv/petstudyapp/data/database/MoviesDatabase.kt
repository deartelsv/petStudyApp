package com.artelsv.petstudyapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.artelsv.petstudyapp.data.database.dao.MovieDao
import com.artelsv.petstudyapp.data.entity.MovieEntity

@Database(entities = [MovieEntity::class], version = 8)
@TypeConverters(DataConverter::class)
abstract class MoviesDatabase : RoomDatabase(){

    abstract fun getMovieDao(): MovieDao
}