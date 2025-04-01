package com.example.myapplication.ui.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun TaskDetailScreen(task: com.example.myapplication.network.Task) {
    Text(text = "Title: ${task.title}")
    Text(text = "Description: ${task.description}")
    Text(text = "Category: ${task.category}")
    Text(text = "Status: ${task.status}")
    Text(text = "Priority: ${task.priority}")
}
