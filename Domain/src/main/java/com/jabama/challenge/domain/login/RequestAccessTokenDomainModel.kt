package com.jabama.challenge.domain.login

data class RequestAccessTokenDomainModel(
    var clientId: String,
    var clientSecret: String,
    var code: String,
    var redirectUri: String,
    var state: String
)
