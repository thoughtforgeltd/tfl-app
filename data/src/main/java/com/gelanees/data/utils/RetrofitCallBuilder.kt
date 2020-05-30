package com.gelanees.data.utils

import retrofit2.Response
import java.io.IOException

suspend fun <T, U> retrofitApiCall(
    call: suspend () -> Response<T>,
    success: (T) -> U,
    failure: (String?, Int) -> U,
    noInternet: () -> U
): U {
    return try {
        val response = call()
        if (response.isSuccessful) {
            success(response.body()!!)
        } else {
            failure(response.errorBody()?.toString(), response.code())
        }
    } catch (e: IOException) {
        noInternet()
    }
}