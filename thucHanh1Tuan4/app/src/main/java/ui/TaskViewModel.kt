package com.example.myapplication.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.network.RetrofitClient
import com.example.myapplication.network.Task
import kotlinx.coroutines.launch

class TaskViewModel : ViewModel() {
    private val _tasks = MutableLiveData<List<Task>>()
    val tasks: LiveData<List<Task>> get() = _tasks

    // Hàm để lấy dữ liệu từ API
    fun fetchTasks() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.getTasks()
                if (response.isSuccessful) {
                    _tasks.value = response.body()?.data  // Gán dữ liệu vào LiveData
                } else {
                    Log.e("API Error", "Error: ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("API Error", "Exception: ${e.message}")
            }
        }
    }
    fun getTaskById(taskId: String): Task? {
        return _tasks.value?.find { it.id.toString() == taskId }
    }
}
