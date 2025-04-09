package com.example.tuan4_mvvm.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.tuan4_mvvm.model.RetrofitInstance
import com.example.tuan4_mvvm.model.Task
class TaskViewModel : ViewModel(){
    private val apiService = RetrofitInstance.api

    var tasks by mutableStateOf<List<Task>>(emptyList())
        private set
    var isLoading by mutableStateOf(true)
        private set
    var error by mutableStateOf<String?>(null)
        private set

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            try {
                isLoading = true
                val response = apiService.getTasks()
                if (response.isSuccess) {
                    tasks = response.data
                    error = null
                } else {
                    error = response.message
                }
            } catch (e: Exception) {
                error = "Lỗi: ${e.message}"
                e.printStackTrace()
            }finally {
                isLoading = false
            }
        }
    }
}