package com.gelanees.data.utils

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun createRetrofit(
    okHttpClient: OkHttpClient, url:
    String = "https://api.tfl.gov.uk/"
): Retrofit {
    return Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

inline fun <reified T> createRetrofitService(retrofit: Retrofit): T {
    return retrofit.create(T::class.java)
}

fun createOkHttpClient(context : Context): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(ChuckerInterceptor(context))
        .build()
}
