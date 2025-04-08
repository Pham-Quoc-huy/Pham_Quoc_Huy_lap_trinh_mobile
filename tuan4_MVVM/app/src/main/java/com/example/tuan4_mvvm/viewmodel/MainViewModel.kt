package com.example.tuan4_mvvm.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.tuan4_mvvm.model.TaskItem

class MainViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState

    // Method to go back to the previous screen
    fun goBack() {
        // Logic for going back
    }

    // Navigate to the Add New screen
    fun navigateToAddNewScreen() {
        // Logic to navigate to the Add New screen
    }

    // Method to navigate between pages (for buttons at the bottom)
    fun navigateToPage(page: Int) {
        // Logic to navigate to a specific page
    }
}

data class UiState(
    val items: List<TaskItem> = listOf(
        TaskItem("Complete Android Project", "Finish the UI, integrate API, and write documentation", "blue"),
        TaskItem("Complete Android Project", "Finish the UI, integrate API, and write documentation", "pink"),
        TaskItem("Complete Android Project", "Finish the UI, integrate API, and write documentation", "green"),
        TaskItem("Complete Android Project", "Finish the UI, integrate API, and write documentation", "red")
    )
)

data class TaskItem(
    val title: String,
    val description: String,
    val color: String // Used to determine the background color
)
