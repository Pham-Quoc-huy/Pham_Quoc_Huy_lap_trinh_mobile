package com.example.tuan7


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tuan7.ui.theme.Tuan7Theme
import com.example.tuan7.viewmodel.TaskViewModel
import com.example.tuan7.view.navigation.NavScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tuan7Theme {
                val taskViewModel: TaskViewModel = viewModel()

                NavScreen(viewModel = taskViewModel)
            }
        }
    }
}

