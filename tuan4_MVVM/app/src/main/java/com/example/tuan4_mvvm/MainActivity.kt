package com.example.tuan4_mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.*
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tuan4_mvvm.ui.theme.Tuan4_MVVMTheme
import com.example.tuan4_mvvm.views.AddNewScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tuan4_mvvm.viewmodel.TaskViewModel
import com.example.tuan4_mvvm.views.NavScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tuan4_MVVMTheme {
                val viewModel: TaskViewModel = viewModel()
                NavScreen(viewModel)
            }
        }
    }
}