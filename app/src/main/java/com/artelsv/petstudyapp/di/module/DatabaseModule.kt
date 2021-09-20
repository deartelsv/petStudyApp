package com.artelsv.petstudyapp.di.module

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.artelsv.petstudyapp.data.database.MoviesDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Inject
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
    fun providesRoomDatabase(): MoviesDatabase = Room.databaseBuilder(applicationContext, MoviesDatabase::class.java, DATABASE_NAME)
        .fallbackToDestructiveMigration()
        .addCallback(databaseCallback)
        .build()

    @Provides
    fun providesMoviesDao(moviesDatabase: MoviesDatabase) = moviesDatabase.getMovieDao()
}