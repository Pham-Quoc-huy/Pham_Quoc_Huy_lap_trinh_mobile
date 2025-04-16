package com.example.tuan7.view.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tuan7.view.AddNewScreen
import com.example.tuan7.viewmodel.TaskViewModel

@Composable
fun NavScreen(viewModel: TaskViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "list") {
        composable("List") {
            ListScreen(navController, viewModel)
        }
        composable("AddNew") {
            AddNewScreen(navController = navController, taskViewModel = viewModel)
        }
    }
}
