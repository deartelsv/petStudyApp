package com.artelsv.petstudyapp.data.network

import com.artelsv.petstudyapp.data.network.model.MovieResponse
import com.artelsv.petstudyapp.data.network.model.RequestTokenResponse
import com.artelsv.petstudyapp.data.network.model.SessionResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UserService {
    @GET("/authentication/token/new$API_KEY")
    fun createRequestToken() : Single<RequestTokenResponse>

    @POST("authentication/session/new$API_KEY")
    fun createSession(@Body body: HashMap<*, *>) : Single<SessionResponse>

    @POST("authentication/token/validate_with_login$API_KEY")
    fun createSessionWithUser(@Body body: HashMap<*, *>) : Single<SessionResponse>
}