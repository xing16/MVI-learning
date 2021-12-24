package com.xing.mvilearning.http

import com.xing.mvilearning.data.service.PlayService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val CONNECTION_TIMEOUT = 10L
private const val WRITE_TIMEOUT = 2L
private const val READ_TIMEOUT = 10L
private const val BASE_URL = "https://www.wanandroid.com/"

object RetrofitClient {
    val okHttpClient = OkHttpClient.Builder().apply {
        connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
        writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
    }.build()
    val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val apiService = retrofit.create(PlayService::class.java)
}