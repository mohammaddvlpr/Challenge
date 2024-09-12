package com.jabama.challenge.network.search

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface SearchService {
    @Headers("Accept:application/json")
    @GET("https://api.github.com/search/repositories?")
    suspend fun search(@Query("q") query: String): Response<SearchRepositoryModel>
}