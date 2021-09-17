package com.artelsv.petstudyapp.di.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.artelsv.petstudyapp.data.repository.MoviesRepositoryImpl
import com.artelsv.petstudyapp.ui.viewmodel.MoviesViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MoviesViewModelFactory @Inject constructor(private val moviesRepository: MoviesRepositoryImpl) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MoviesViewModel(moviesRepository)  as T
    }
}