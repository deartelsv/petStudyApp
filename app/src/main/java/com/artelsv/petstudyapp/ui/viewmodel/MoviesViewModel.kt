package com.artelsv.petstudyapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.artelsv.petstudyapp.data.repository.MoviesRepositoryImpl

class MoviesViewModel(private val moviesRepository: MoviesRepositoryImpl) : ViewModel() {

    init {
        getMovies()
    }

    fun getMovies() {
        moviesRepository.getMovies()
    }
}