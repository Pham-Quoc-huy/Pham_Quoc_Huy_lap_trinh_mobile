package com.example.myapplication.network

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("tasks")
    suspend fun getTasks(): Response<TaskResponse>
}

data class TaskResponse(
    val isSuccess: Boolean,
    val message: String,
    val data: List<Task>
)

data class Task(
    val id: Int,
    val title: String,
    val description: String,
    val status: String,
    val priority: String,
    val category: String,
    val dueDate: String,
    val subtasks: List<Subtask>,
    val attachments: List<Attachment>,
    val reminders: List<Reminder>
)

data class Subtask(val id: Int, val title: String, val isCompleted: Boolean)
data class Attachment(val id: Int, val fileName: String, val fileUrl: String)
data class Reminder(val id: Int, val time: String, val type: String)
