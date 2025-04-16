package com.example.tuan7.repository

import com.example.tuan7.data.entities.DAO.TaskDAO
import com.example.tuan7.data.entities.Task


class TaskRepository(private val dao: TaskDAO) {
    suspend fun getAllTasks() = dao.getAllTasks()
    suspend fun insertTask(task: Task) = dao.insertTask(task)
    suspend fun deleteTask(task: Task) = dao.deleteTask(task)
}