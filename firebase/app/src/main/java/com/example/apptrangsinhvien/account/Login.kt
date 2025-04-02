package com.example.apptrangsinhvien.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.apptrangsinhvien.R

@Composable
fun LoginFlow(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box() {
            Image(
                painter = painterResource(id = R.drawable.uthxanh),
                contentDescription = null,
                modifier = Modifier.size(400.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.nenuth),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(200.dp)
            )
            Text(
                text = "SmartTasks",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2196F3),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 16.dp)
            )
            Text(
                text = "A simple and efficient to-do app",
                fontSize = 12.sp,
                color = Color(0xFF2196F3),
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
        Spacer(modifier = Modifier.padding(32.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Welcome",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "Ready to explore? Log in to get started.",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }

        Spacer(modifier = Modifier.padding(32.dp))

        // Điều hướng đến UserProfile khi nhấn vào nút "Welcome"
        Button(
            onClick = { navController.navigate("userProfile") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2196F3),
                contentColor = Color.Black
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically, // Đảm bảo các thành phần trong Row được căn giữa theo chiều dọc
                horizontalArrangement = Arrangement.Center // Nếu muốn căn giữa cả hàng
            ) {
                // Thêm hình ảnh bên cạnh chữ
                Image(
                    painter = painterResource(id = R.drawable.gg), // Thay ic_google bằng hình ảnh bạn muốn
                    contentDescription = "Google logo",
                    modifier = Modifier.size(24.dp) // Điều chỉnh kích thước hình ảnh
                )

                Spacer(modifier = Modifier.width(8.dp)) // Khoảng cách giữa hình ảnh và chữ

                Text("Sign in with Google")
            }
        }

    }
}
@Preview(showSystemUi = true)
@Composable
fun Demo() {
    // Thêm NavController khi preview
    LoginFlow(navController = rememberNavController())
}
