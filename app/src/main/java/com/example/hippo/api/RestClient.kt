package com.example.hippo.api

import com.example.hippo.BuildConfig
import com.example.hippo.api.service.*
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RestClient {
    private val okHttpBuilder: OkHttpClient.Builder = OkHttpClient.Builder().apply {
        connectTimeout(60, TimeUnit.SECONDS)
        readTimeout(60, TimeUnit.SECONDS)
        writeTimeout(60, TimeUnit.SECONDS)
        addInterceptor(object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                    .header("Content-Type", "application/json")

                val request = requestBuilder.build()
                return chain.proceed(request)
            }
        })
    }

    private val retrofit = Retrofit.Builder().apply {
        baseUrl(BuildConfig.BASE_URL)
        client(okHttpBuilder.build())
        addConverterFactory(GsonConverterFactory.create())
        addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    }.build()

    var authService: AuthService
    var chatService: ChatService
    var favoritesService: FavoritesService
    var reportService: ReportService
    var userService: UserService

    init {
        authService = retrofit.create(AuthService::class.java)
        chatService = retrofit.create(ChatService::class.java)
        favoritesService = retrofit.create(FavoritesService::class.java)
        reportService = retrofit.create(ReportService::class.java)
        userService = retrofit.create(UserService::class.java)
    }

    companion object {
        val instance: RestClient by lazy { RestClient() }
    }
}