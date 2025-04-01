package navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import ui.screens.component
import androidx.compose.material3.Text
import androidx.navigation.compose.rememberNavController
import ui.screens.TaskDetail
import ui.screens.root

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "Root") {
        composable("Root") {
            component(navController = navController)
        }
        composable("TaskDetail") {
            TaskDetail() // Navigate to task detail screen
        }
    }
}
