package com.jabama.challenge.network.search

import com.jabama.challenge.network.PAGE_SIZE
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface SearchService {
    @Headers("Accept:application/json")
    @GET("/search/repositories?per_page=$PAGE_SIZE")
    suspend fun search(@Query("q") query: String): Response<SearchRepositoryModel>
}