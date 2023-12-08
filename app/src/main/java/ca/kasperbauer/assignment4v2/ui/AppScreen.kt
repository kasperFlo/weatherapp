package ca.kasperbauer.assignment4v2.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ca.kasperbauer.assignment4v2.ui.navigation.RollerNavHost

@Composable
fun AppScreen(navController: NavHostController = rememberNavController()) {
    RollerNavHost(navController = navController)
}