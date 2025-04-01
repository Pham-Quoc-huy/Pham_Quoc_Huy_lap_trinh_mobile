package com.example.bai1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuthException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        setContent {
            LoginScreen()
        }
    }

    @Composable
    fun LoginScreen() {
        var errorMessage by remember { mutableStateOf("") }
        var successMessage by remember { mutableStateOf("") }

        // Layout for the Login screen
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Login with Google", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    googleSignIn { result ->
                        if (result.isSuccess) {
                            successMessage = "Login Successful"
                            errorMessage = ""
                        } else {
                            successMessage = ""
                            errorMessage = result.errorMessage ?: "Login Failed"
                        }
                    }
                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Login by Gmail")
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Display success or error messages
            if (errorMessage.isNotEmpty()) {
                Text(text = errorMessage, color = MaterialTheme.colorScheme.error)
            }
            if (successMessage.isNotEmpty()) {
                Text(text = successMessage, color = MaterialTheme.colorScheme.primary)
            }
        }
    }

    // Function for handling Google Sign-In and Firebase Authentication
    private fun googleSignIn(callback: (AuthResultResult) -> Unit) {
        // This is where you will integrate Google Sign-In using Firebase
        val task = FirebaseAuth.getInstance().signInWithCredential(GoogleAuthProvider.getCredential("googleToken", null))

        task.addOnCompleteListener {
            if (it.isSuccessful) {
                callback(AuthResultResult(true, ""))
            } else {
                callback(AuthResultResult(false, it.exception?.message))
            }
        }
    }
}

// Data class to wrap AuthResult
data class AuthResultResult(val isSuccess: Boolean, val errorMessage: String?)
