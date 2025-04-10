package com.example.tuan7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tuan7.ui.theme.Tuan7Theme
import views.SettingScreen  // Import SettingScreen từ views package

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tuan7Theme {
                // Sử dụng SettingScreen trong MainActivity
                SettingScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Tuan7Theme {
        SettingScreen()  // Hiển thị SettingScreen khi xem preview
    }
}
