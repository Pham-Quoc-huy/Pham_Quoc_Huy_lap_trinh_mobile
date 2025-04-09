package com.example.tuan4_mvvm.views

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tuan4_mvvm.viewmodel.TaskViewModel

@Composable
fun NavScreen(viewModel: TaskViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
            ListScreen(navController, viewModel())
        }
        composable("details/{taskId}") { backStackEntry ->
            val taskId = backStackEntry.arguments?.getString("taskId")?.toIntOrNull()
            if (taskId != null) {
                DetailsListScreen(taskId,navController = navController)
            }
        }
        composable("addnew"){
            AddNewScreen(navController)
        }
    }
}