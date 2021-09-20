package com.artelsv.petstudyapp.di.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.artelsv.petstudyapp.data.repository.UserRepositoryImpl
import com.artelsv.petstudyapp.ui.viewmodel.AuthViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthViewModelFactory @Inject constructor(private val userRepository: UserRepositoryImpl) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AuthViewModel(userRepository)  as T
    }
}