package com.jabama.challenge.data.repository

import retrofit2.Response

inline fun <T : Any> apiCall(call: () -> Response<T>): Result<T> {
    return try {
        val result = call.invoke()
        if (result.isSuccessful && result.body() != null)
            Result.success(result.body()!!)
        else
            Result.failure(Exception("Response body is null") )


    } catch (e: Exception) {
        e.printStackTrace()
        Result.failure(e)
    }
}