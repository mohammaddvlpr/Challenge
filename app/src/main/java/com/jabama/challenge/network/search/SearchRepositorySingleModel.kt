package com.jabama.challenge.network.search

import com.google.gson.annotations.SerializedName

data class SearchRepositorySingleModel(
    @SerializedName("full_name") val fullName: String,
    @SerializedName("avatar_url") val avatarUrl: String?,
    @SerializedName("url") val url: String,
    @SerializedName("private") val isPrivate: Boolean
)
