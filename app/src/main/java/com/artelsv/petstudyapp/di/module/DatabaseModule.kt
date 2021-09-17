package com.artelsv.petstudyapp.di.module

import android.app.Application
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.artelsv.petstudyapp.data.database.MoviesDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

const val DATABASE_NAME = "movies_database"

@Module
class DatabaseModule(private val application: Application) {

    private lateinit var moviesDatabase: MoviesDatabase

    private val databaseCallback = object : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            Log.d("RoomDatabaseModule", "onCreate")
        }
    }

    @Singleton
    @Provides
    fun providesRoomDatabase(): MoviesDatabase {
        moviesDatabase = Room.databaseBuilder(application, MoviesDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .addCallback(databaseCallback)
            .build()
        return moviesDatabase
    }

    @Singleton
    @Provides
    fun providesMoviesDao(moviesDatabase: MoviesDatabase) = moviesDatabase.getMovieDao()
}