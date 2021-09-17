package com.artelsv.petstudyapp.data.network.model

import com.google.gson.annotations.SerializedName

data class SessionResponse(
    val success: Boolean? = null,
    @SerializedName("session_id") val sessionId: String? = null,
    @SerializedName("expires_at") val expiresAt: String? = null,
    @SerializedName("request_token") val requestToken: String? = null,
    @SerializedName("status_message") val statusMessage: String? = null,
    @SerializedName("status_code") val statusCode: Int? = null
)