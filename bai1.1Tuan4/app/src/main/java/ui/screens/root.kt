package ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.navigation.NavHostController
import androidx.compose.ui.tooling.preview.Preview
import com.example.bai11tuan4.R

@Composable

fun Ready(navController: NavHostController){
    Column(modifier = Modifier.fillMaxSize()
        .background(color = Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(
            painter = painterResource(id = R.drawable.compose_logo),
            contentDescription = "jetpack compose",
            Modifier.size(300.dp)
                .padding(20.dp)
        )
        Text(
            text = "Jetpack compose",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(20.dp)
        )
        Text(
            text = "Jetpack Compose is a modern UI toolkit for building native Android applications using a declarative programming approach.",
            color = Color.Gray,
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            modifier = Modifier.padding(10.dp)
        )
        Button(onClick = {
            navController.navigate(route = "Components")
        }, modifier = Modifier.padding(top = 90.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
        ) {
            Text(
                text = "I'm Ready",
                modifier = Modifier.padding(start = 40.dp, end = 40.dp)
            )
        }
    }
}
