    package navigation

    import androidx.compose.runtime.Composable
    import androidx.navigation.NavHostController // Sử dụng NavHostController thay vì NavController
    import androidx.navigation.compose.NavHost
    import androidx.navigation.compose.composable
    import com.example.apptrangsinhvien.account.LoginFlow
    import com.example.apptrangsinhvien.account.UserProfile
    @Composable
    fun SetupNavigation(navController: NavHostController) { // Sửa NavController thành NavHostController
        NavHost(navController = navController, startDestination = "login") {
            composable("login") {
                LoginFlow(navController = navController)
            }
            composable("userProfile") {
                UserProfile(navController = navController)
            }
        }
    }
