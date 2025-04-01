package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.ui.screens.HomeScreen
import com.example.myapplication.ui.screens.TaskDetailScreen
import com.example.myapplication.ui.TaskViewModel

@Composable
fun SetupNavigation(navController: NavHostController, taskViewModel: TaskViewModel) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(viewModel = taskViewModel)
        }

        composable("taskDetail/{taskId}") { backStackEntry ->
            val taskId = backStackEntry.arguments?.getString("taskId")
            val task = taskViewModel.getTaskById(taskId!!)
            TaskDetailScreen(task = task!!)
        }
    }
}
