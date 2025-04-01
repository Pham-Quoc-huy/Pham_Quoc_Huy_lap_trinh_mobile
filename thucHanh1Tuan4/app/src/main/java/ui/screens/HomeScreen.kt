package com.example.myapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.runtime.livedata.observeAsState
import com.example.myapplication.network.Task
import com.example.myapplication.ui.TaskViewModel
import com.example.myapplication.R  // Import resource file for the logo
import androidx.compose.ui.Alignment
import androidx.compose.material3.BottomNavigation
import androidx.compose.material3.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.Home

@Composable
fun HomeScreen(viewModel: TaskViewModel) {
    val tasks = viewModel.tasks.observeAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Thêm logo ở phía trên đầu trang
        Image(
            painter = painterResource(id = R.drawable.logo_uth), // Chắc chắn bạn có logo trong drawable
            contentDescription = "Logo",
            modifier = Modifier
                .size(80.dp) // Chỉnh kích thước logo theo ý muốn
                .align(Alignment.CenterHorizontally)
        )

        // Tiêu đề ứng dụng hoặc văn bản mô tả (nếu cần)
        Text(
            text = "SmartTasks",
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .padding(vertical = 16.dp)
                .align(Alignment.CenterHorizontally)
        )

        // LazyColumn hiển thị danh sách các task
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(tasks.value) { task ->
                TaskItem(task)
            }
        }

        // Thêm Bottom Navigation ở dưới
        BottomNavigationBar()
    }
}

@Composable
fun TaskItem(task: Task) {
    val backgroundColor = when (task.status) {
        "In Progress" -> Color(0xFFFFC0CB) // Màu hồng cho trạng thái 'In Progress'
        "Completed" -> Color(0xFF98FB98) // Màu xanh lá cho trạng thái 'Completed'
        else -> Color(0xFFADD8E6) // Màu xanh dương cho trạng thái 'Pending'
    }

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = backgroundColor)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Tiêu đề task
            Text(
                text = task.title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Mô tả task
            Text(
                text = task.description,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Hiển thị category và status
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Category: ${task.category}",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Status: ${task.status}",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold
                )
            }

            // Hiển thị thời gian hoàn thành
            Text(
                text = "Due Date: ${task.dueDate}",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Composable
fun BottomNavigationBar() {
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.Black
    ) {
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = true,
            onClick = { /* Handle navigation */ }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Event, contentDescription = "Tasks") },
            label = { Text("Tasks") },
            selected = false,
            onClick = { /* Handle navigation */ }
        )
    }
}
