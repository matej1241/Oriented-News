package com.matej.orientednews.di

import com.matej.orientednews.common.BASE_URL
import com.matej.orientednews.common.LOGGING_INTERCEPTOR
import com.matej.orientednews.networking.RssApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkingModule = module {

    single { GsonConverterFactory.create() as Converter.Factory }

    single ( named(LOGGING_INTERCEPTOR)){ HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY) }

    single {
        OkHttpClient.Builder().apply {
            addInterceptor(get(named(LOGGING_INTERCEPTOR)))
            readTimeout(1L, TimeUnit.MINUTES)
            connectTimeout(1L, TimeUnit.MINUTES)
        }.build()
    }

    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(RssApiService::class.java) }
}