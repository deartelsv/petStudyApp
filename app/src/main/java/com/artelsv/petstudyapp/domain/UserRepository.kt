package com.artelsv.petstudyapp.domain

import com.artelsv.petstudyapp.data.network.model.RequestTokenResponse
import com.artelsv.petstudyapp.data.network.model.SessionResponse
import io.reactivex.Single

interface UserRepository {

    fun createRequestToken() : Single<RequestTokenResponse>
    fun createSession(requestToken: String) : Single<SessionResponse>
    fun createSessionWithUser(requestToken: String, login: String, password: String) : Single<SessionResponse>
}