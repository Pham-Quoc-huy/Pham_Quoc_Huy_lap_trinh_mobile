package com.example.tuan4_mvvm.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
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
import com.example.tuan4_mvvm.R
import com.example.tuan4_mvvm.model.Attachment
import com.example.tuan4_mvvm.model.Subtask
import com.example.tuan4_mvvm.model.Task
import com.example.tuan4_mvvm.viewmodel.TaskViewModel

@Composable
fun SubtaskItem(subtask: Subtask){
    Card(
        modifier = Modifier.fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .padding(vertical = 8.dp)
    ) {
        Text(text = "${subtask.title}",
            modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun AttachmentItem(attachment: Attachment){
    Card(
        modifier = Modifier.fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .padding(vertical = 8.dp)
    ) {
        Text(text = "${attachment.fileName}",
            modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun DetailsList(task: Task, subtasks: List<Subtask>,
                attachments: List<Attachment>,
                navController: NavHostController){

    Column(
        modifier = Modifier.padding(16.dp)
            .fillMaxSize(),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {
                navController.navigate("list")
            },
                modifier = Modifier
                    .clip(RoundedCornerShape(2.dp))
                    .size(56.dp),
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color(0xFF2196F3),
                    contentColor = Color.White
                )) {
                Icon(painter = painterResource(id = R.drawable.baseline_arrow_back_ios_new_24),
                    contentDescription = null,
                    modifier = Modifier.clip(RoundedCornerShape(10.dp)))
            }
            Text(text = "List",
                fontSize = 32.sp,
                color = Color(0xFF2196F3),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth().weight(1f),
                textAlign = TextAlign.Center)
        }
        Spacer(modifier = Modifier.padding(8.dp))

        Text(text = "${task.title}",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold)
        Text(text = "${task.description}")

        Spacer(modifier = Modifier.padding(8.dp))

        Text(text = "Subtasks",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold)

        LazyColumn(modifier = Modifier.fillMaxSize()
            .weight(1f)) {
            items(subtasks) { subtask ->
                SubtaskItem(subtask)
            }
        }

        Spacer(modifier = Modifier.padding(8.dp))

        Text(text = "Attchments",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold)

        LazyColumn(modifier = Modifier.fillMaxSize()
            .weight(1f)) {
            items(attachments) { attachment ->
                AttachmentItem(attachment)
            }

        }
    }
}

@Composable
fun DetailsListScreen(taskId: Int,navController: NavHostController) {
    val viewModel: TaskViewModel = viewModel()
    val task = viewModel.tasks.find { it.id == taskId }

    task?.let {
        DetailsList(it, it.subtasks, it.attachments, navController)
    } ?: Text("Không tìm thấy nhiệm vụ")
}
