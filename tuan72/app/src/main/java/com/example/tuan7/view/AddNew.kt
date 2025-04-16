package com.example.tuan7.view


import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.tuan7.R
import com.example.tuan7.data.entities.Task
import com.example.tuan7.viewmodel.TaskViewModel

@Composable
fun AddNewScreen(navController: NavHostController,taskViewModel: TaskViewModel){

    val taskText = remember { mutableStateOf("") }
    val descriptionText = remember { mutableStateOf("") }
    val statusText = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp,32.dp)
    ) {
        Column(
            modifier = Modifier.weight(1f).padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Card(
                    onClick = {
                        navController.navigate("list")
                    },
                    colors = CardDefaults.cardColors(
                        contentColor = Color.White,
                        containerColor = Color(0xFF2196F3)
                    ),
                    modifier = Modifier
                        .size(56.dp)
                        .clip(RoundedCornerShape(6.dp))
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_arrow_back_ios_new_24),
                        contentDescription = null,
                        modifier = Modifier.size(56.dp)
                    )
                }
                Text(
                    text = "Add New",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF2196F3),
                    textAlign = TextAlign.Center
                )
                Card(
                    colors = CardDefaults.cardColors(
                        contentColor = Color.White,
                        containerColor = Color.White
                    ),
                    modifier = Modifier
                        .size(56.dp)
                        .clip(RoundedCornerShape(6.dp)
                        )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_add_24),
                        contentDescription = null,
                        modifier = Modifier.size(56.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.padding(16.dp))

            Text("Task",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,)

            Spacer(modifier = Modifier.padding(8.dp))

            Card(modifier = Modifier.fillMaxWidth().border(2.dp, Color(0x544C4C24), RoundedCornerShape(8.dp)),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp)){
                TextField(
                    value = taskText.value,
                    onValueChange = { taskText.value = it },
                    placeholder = { Text("Task") },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.padding(8.dp))

            Text("Description",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,)

            Spacer(modifier = Modifier.padding(8.dp))

            Card(modifier = Modifier.fillMaxWidth().border(2.dp, Color(0x544C4C24), RoundedCornerShape(8.dp)),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp)){
                TextField(
                    value = descriptionText.value,
                    onValueChange = { descriptionText.value = it },
                    placeholder = { Text("Description") },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.padding(8.dp))

            Text("Status ( Completed , In Progress , Pending )",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,)

            Spacer(modifier = Modifier.padding(8.dp))

            Card(modifier = Modifier.fillMaxWidth().border(2.dp, Color(0x544C4C24), RoundedCornerShape(8.dp)),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp)){
                TextField(
                    value = statusText.value,
                    onValueChange = { statusText.value = it },
                    placeholder = { Text("Status") },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.padding(8.dp))

            Button(onClick = {
                if (taskText.value.isNotEmpty() && descriptionText.value.isNotEmpty()) {
                    val task = Task(
                        title = taskText.value,
                        description = descriptionText.value,
                        status = statusText.value
                    )
                    taskViewModel.addTask(task)

                    navController.navigate("list")
                }
            }, modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 100.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2196F3)
                )
            ) {
                Text("Add",
                    fontSize = 24.sp)
            }
        }
    }
}