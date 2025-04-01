package ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color

@Composable
fun TaskDetailScreen() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Task Detail",
            fontSize = 30.sp,
            color = Color.Blue
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Here is the detailed information about the task.",
            fontSize = 20.sp,
            color = Color.Black
        )
    }
}
