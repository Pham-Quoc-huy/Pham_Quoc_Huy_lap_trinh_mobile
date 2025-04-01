package ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.material3.IconButton
import com.example.bai11tuan4.R

@Composable
fun Component(navController: NavHostController) {
    // Sample data for the LazyColumn
    val itemsList = List(1000) { "The only way to do great work is to love what you do." }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFB3E5FC))  // Thêm màu nền xanh nhạt
    ) {
        // Mũi tên quay lại ở trên cùng của màn hình
        IconButton(onClick = {
            navController.popBackStack() // Go back to the previous screen
        }) {
            Icon(
                painter = painterResource(id = R.drawable.icon_1), // Thay bằng tên icon của bạn
                contentDescription = "Back Icon",
                modifier = Modifier.size(24.dp)
            )
        }

        Text(
            text = "LazyColumn ",
            fontSize = 30.sp,
            color = Color.Blue,
            modifier = Modifier.padding(top = 50.dp)
        )

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(itemsList) { item ->
                // Card for each item in the LazyColumn
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp),
                    shape = MaterialTheme.shapes.medium,
                    colors = CardDefaults.cardColors(containerColor = Color.LightGray),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = item,
                            modifier = Modifier.weight(1f),
                            fontSize = 16.sp,
                            color = Color.Black
                        )

                        // Chỉ hiển thị mũi tên bên phải để điều hướng đến màn hình chi tiết
                        IconButton(onClick = {
                            navController.navigate("TaskDetail") // Navigate to Task Detail screen
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.icon_2), // Thay bằng tên icon của bạn
                                contentDescription = "Next Icon",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}
