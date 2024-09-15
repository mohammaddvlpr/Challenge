package com.jabama.challenge.domain.search.model

data class SearchModel(
    val id:Long,
    val fullName: String,
    val avatarUrl: String?,
    val url: String,
    val isPrivate: Boolean
)
