package com.jabama.challenge.domain.login

data class ResponseAccessTokenDomainModel(
    var accessToken: String,
    var tokenType: String
)