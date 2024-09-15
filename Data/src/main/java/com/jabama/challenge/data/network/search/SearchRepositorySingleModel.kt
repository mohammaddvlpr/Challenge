package com.jabama.challenge.data.network.search

import com.google.gson.annotations.SerializedName

data class SearchRepositorySingleModel(
    @SerializedName("id") val id:Long,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("avatar_url") val avatarUrl: String?,
    @SerializedName("html_url") val url: String,
    @SerializedName("private") val isPrivate: Boolean
)
