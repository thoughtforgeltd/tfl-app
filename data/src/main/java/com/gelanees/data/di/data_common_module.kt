package com.gelanees.data.di

import com.gelanees.data.utils.createOkHttpClient
import com.gelanees.data.utils.createRetrofit
import org.koin.dsl.module

val data_common_module = module {
    single { createOkHttpClient(get()) }
    single { createRetrofit(get()) }
}