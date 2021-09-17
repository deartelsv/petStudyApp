package com.artelsv.petstudyapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.artelsv.petstudyapp.data.repository.UserRepositoryImpl
import com.artelsv.petstudyapp.domain.UserRepository
import io.reactivex.schedulers.Schedulers

class AuthViewModel(private val userRepository: UserRepositoryImpl) : ViewModel() {

    init {
        createRequestToken()
    }

    private fun createRequestToken() {

    }
}