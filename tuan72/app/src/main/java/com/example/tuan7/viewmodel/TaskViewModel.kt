package com.example.tuan7.viewmodel


import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.tuan7.data.entities.AppDatabase
import com.example.tuan7.data.entities.Task
import com.example.tuan7.repository.TaskRepository
import kotlinx.coroutines.launch

class TaskViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: TaskRepository
    var tasks = mutableStateOf<List<Task>>(emptyList())
        private set
    var isLoading = mutableStateOf(false)
    var error = mutableStateOf<String?>(null)

    init {
        val dao = AppDatabase.getDatabase(application).taskDao()
        repository = TaskRepository(dao)
        fetchTasks()
    }

    fun fetchTasks() {
        viewModelScope.launch {
            isLoading.value = true
            try {
                tasks.value = repository.getAllTasks()
                error.value = null
            } catch (e: Exception) {
                error.value = e.message
            } finally {
                isLoading.value = false
            }
        }
    }

    fun addTask(task: Task) {
        viewModelScope.launch {
            try {
                repository.insertTask(task)
                fetchTasks()
            } catch (e: Exception) {
                error.value = "Failed to add task: ${e.message}"
            }
        }
    }
}

