package com.example.tuan7.view.navigation


import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tuan7.R
import androidx.compose.foundation.shape.CircleShape
import androidx.navigation.NavHostController
import com.example.tuan7.data.entities.Task
import com.example.tuan7.viewmodel.TaskViewModel

@Composable
fun ListItem(task: Task){
    val backgroundColor = when (task.status){
        "Completed" -> Color(0xFFDDE1B6)
        "In Progress" -> Color(0x4D2196F3)
        else -> Color(0xFFE1BBC1)
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(4.dp),
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
                .background(color = backgroundColor),

            ) {
            Column(modifier = Modifier.padding(12.dp)
                .weight(1f)) {
                Text(text = "${task.title}",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.padding(4.dp))

                Text(text = "${task.description}")
            }
        }
    }
}


@Composable
fun ListScreen(navController: NavHostController, viewModel: TaskViewModel) {
    val tasks = viewModel.tasks.value
    val isLoading = viewModel.isLoading.value
    val error = viewModel.error.value

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp, 32.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Card(
                onClick = { navController.popBackStack() },
                colors = CardDefaults.cardColors(contentColor = Color.White, containerColor = Color(0xFF2196F3)),
                modifier = Modifier.size(56.dp).clip(RoundedCornerShape(6.dp))
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_back_ios_new_24),
                    contentDescription = null,
                    modifier = Modifier.size(56.dp)
                )
            }
            Text(
                text = "List",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2196F3),
                textAlign = TextAlign.Center
            )
            Card(
                onClick = { navController.navigate("addnew") },
                colors = CardDefaults.cardColors(contentColor = Color.White, containerColor = Color(0xFF2196F3)),
                modifier = Modifier.size(56.dp).clip(RoundedCornerShape(6.dp))
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_add_24),
                    contentDescription = null,
                    modifier = Modifier.size(56.dp)
                )
            }
        }

        Spacer(modifier = Modifier.padding(16.dp))

        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        } else if (error != null) {
            Text(text = "Error: $error", color = Color.Red, modifier = Modifier.align(Alignment.CenterHorizontally))
        } else {
            // Hiển thị danh sách task
            LazyColumn(modifier = Modifier.fillMaxWidth().weight(1f)) {
                items(tasks) { task ->
                    ListItem(task)
                }
            }
        }

        Spacer(modifier = Modifier.padding(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Card(
                modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(painter = painterResource(id = R.drawable.home), contentDescription = null, modifier = Modifier.size(44.dp))
                    Icon(painter = painterResource(id = R.drawable.daily), contentDescription = null, modifier = Modifier.size(44.dp))
                    Spacer(modifier = Modifier.size(56.dp))
                    Icon(painter = painterResource(id = R.drawable.content1), contentDescription = null, modifier = Modifier.size(44.dp))
                    Icon(painter = painterResource(id = R.drawable.setting), contentDescription = null, modifier = Modifier.size(44.dp))
                }
            }

            // Nút thêm task nổi
            Card(
                onClick = { navController.navigate("addnew") },
                modifier = Modifier
                    .size(64.dp)
                    .align(Alignment.TopCenter)
                    .offset(y = (-20).dp),
                shape = CircleShape,
                elevation = CardDefaults.cardElevation(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF2196F3), contentColor = Color.White)
            ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_add_24),
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)
                    )
                }
            }
        }
    }
}