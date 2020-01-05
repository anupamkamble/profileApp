package com.profileapp.data.remote.network

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit


object NetworkClass {

    const val HEADER_API_KEY = "x-api-key"
    const val HEADER_ACCESS_TOKEN = "x-access-token"
    const val HEADER_USER_ID = "x-user-id"

    private const val NETWORK_CALL_TIMEOUT = 60
    lateinit var API_KEY: String

    fun create(apiKey : String, baseUrl: String, cacheDir: File, cacheSize : Long): NetworkServices {

        API_KEY = apiKey

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(
                OkHttpClient().newBuilder()
                    .cache(Cache(cacheDir, cacheSize))
                    .addInterceptor(HttpLoggingInterceptor()
                        .apply {
                            level = if (true) HttpLoggingInterceptor.Level.BODY
                            else HttpLoggingInterceptor.Level.BODY
                        })
                    .readTimeout(NETWORK_CALL_TIMEOUT.toLong(), TimeUnit.SECONDS)
                    .writeTimeout(NETWORK_CALL_TIMEOUT.toLong(), TimeUnit.SECONDS)
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(NetworkServices::class.java)
    }

}