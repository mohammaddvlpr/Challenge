package com.jabama.challenge.domain.auth.models

data class ResponseAccessTokenDomainModel(
    var accessToken: String,
    var tokenType: String
)