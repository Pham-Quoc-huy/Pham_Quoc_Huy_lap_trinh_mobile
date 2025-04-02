package com.example.apptrangsinhvien

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.apptrangsinhvien.account.LoginFlow
import com.example.apptrangsinhvien.account.UserProfile
import com.example.apptrangsinhvien.ui.theme.AppTrangSinhVienTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTrangSinhVienTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "login") {
                    composable("login") {
                        LoginFlow(navController = navController)
                    }
                    composable("userProfile") {
                        UserProfile(navController = navController) // Truyền NavController vào UserProfile
                    }
                }
            }
        }
    }
}
