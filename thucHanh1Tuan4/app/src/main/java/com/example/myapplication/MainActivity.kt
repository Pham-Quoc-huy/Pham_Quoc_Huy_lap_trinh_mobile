package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.ui.screens.HomeScreen
import com.example.myapplication.ui.screens.TaskDetailScreen
import com.example.myapplication.ui.TaskViewModel

class MainActivity : ComponentActivity() {

    // Khởi tạo ViewModel
    private val taskViewModel: TaskViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Gọi hàm fetchTasks() để lấy dữ liệu khi Activity được tạo
        taskViewModel.fetchTasks()

        // Set content cho Activity, truyền Navigation vào
        setContent {
            Navigation(taskViewModel = taskViewModel)
        }
    }

    // Cấu hình Navigation trong Composable
    @Composable
    fun Navigation(taskViewModel: TaskViewModel) {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "home") {
            composable("home") {
                // Sửa tham số truyền vào HomeScreen, không cần truyền thêm callback
                HomeScreen(viewModel = taskViewModel)
            }

            // Màn hình chi tiết của Task
            composable("taskDetail/{taskId}") { backStackEntry ->
                // Lấy taskId từ arguments
                val taskId = backStackEntry.arguments?.getString("taskId")
                val task = taskViewModel.getTaskById(taskId!!)
                TaskDetailScreen(task = task!!)
                }
            }
        }
    }

