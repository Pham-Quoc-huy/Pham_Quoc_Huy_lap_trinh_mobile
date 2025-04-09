package com.example.tuan4_mvvm.model
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object RetrofitInstance {
    val api: TaskApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://amock.io/api/researchUTH/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TaskApiService::class.java)
    }
}