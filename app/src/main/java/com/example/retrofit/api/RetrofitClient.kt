package com.example.retrofit.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://random.dog/" // Базовый URL API

    val apiService: DogApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) // Конвертер JSON в объекты Kotlin
            .build()
            .create(DogApiService::class.java) // Создаем реализацию интерфейса
    }
}