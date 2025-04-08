package com.example.apptrangsinhvien.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.apptrangsinhvien.R
import androidx.compose.ui.draw.clip
@Composable
fun UserProfile(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Nút quay lại
            Card(
                onClick = { navController.popBackStack() }, // Quay lại màn hình trước
                modifier = Modifier.size(56.dp),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF2196F3),
                    contentColor = Color.White
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Text(
                "Profile",
                modifier = Modifier.weight(1f).fillMaxWidth(),
                color = Color(0xFF2196F3),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.padding(16.dp))

        Box() {
            Image(
                painter = painterResource(id = R.drawable.nenuth),
                contentDescription = null,
                modifier = Modifier
                    .size(180.dp)
                    .align(Alignment.Center)
                    .clip(CircleShape)
            )
            Image(
                painter = painterResource(id = R.drawable.vector),
                contentDescription = null,
                modifier = Modifier.size(32.dp).align(Alignment.BottomEnd)
            )
        }

        Spacer(modifier = Modifier.padding(16.dp))

        Column(modifier = Modifier.fillMaxSize()) {
            // Nội dung không thay đổi
            Text("Name", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(2.dp, Color(0x544C4C24), RoundedCornerShape(8.dp)),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Text("Melissa Peters", modifier = Modifier.padding(16.dp), fontSize = 16.sp)
            }

            Text("Email", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(2.dp, Color(0x544C4C24), RoundedCornerShape(8.dp)),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Text("melpeters@gmail.com", modifier = Modifier.padding(16.dp), fontSize = 16.sp)
            }

            Text("Date of Birth", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(2.dp, Color(0x544C4C24), RoundedCornerShape(8.dp)),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Text("23/05/1995", modifier = Modifier.padding(16.dp), fontSize = 16.sp)
            }
        }

        Spacer(modifier = Modifier.padding(16.dp))

        // Nút Back để quay lại màn hình Login
        Button(
            onClick = { navController.navigate("login") }, // Chuyển về màn hình Login
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2196F3), // Màu nền của Button
                contentColor = Color.White // Màu chữ của Button
            ),
            shape = RoundedCornerShape(10.dp), // Độ bo góc
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(48.dp)
        ) {
            Text("Back", fontSize = 16.sp, fontWeight = FontWeight.Bold) // Văn bản Button
        }
    }
}

