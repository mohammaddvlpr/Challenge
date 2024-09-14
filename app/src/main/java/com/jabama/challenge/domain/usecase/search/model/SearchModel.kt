package com.jabama.challenge.domain.usecase.search.model

data class SearchModel(
    val fullName: String,
    val avatarUrl: String?,
    val url: String,
    val isPrivate: Boolean
)
