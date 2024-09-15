package com.jabama.challenge.data.network.auth.models

import com.google.gson.annotations.SerializedName

data class ResponseAccessToken(
    @SerializedName("access_token")
    var accessToken: String,

    @SerializedName("token_type")
    var tokenType: String
)