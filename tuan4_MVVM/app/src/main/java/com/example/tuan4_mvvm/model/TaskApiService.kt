package com.example.tuan4_mvvm.model
import retrofit2.http.GET

interface TaskApiService {
    @GET("tasks")
    suspend fun getTasks(): ApiResponse

    companion object
}