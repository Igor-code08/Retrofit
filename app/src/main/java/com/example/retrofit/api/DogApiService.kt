package com.example.retrofit.api

import com.example.retrofit.ApiData
import retrofit2.http.GET

// Интерфейс для работы с API
interface DogApiService {
    @GET("woof.json?ref=apilist.fun")
    suspend fun getRandomDog(): ApiData // Возвращаемый тип данных
}