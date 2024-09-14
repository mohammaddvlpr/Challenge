package com.jabama.challenge.ui.search.model

data class SearchUiModel(
    val id :Long,
    val fullName: String,
    val avatarUrl: String?,
    val url: String,
    val privacy: String
)
