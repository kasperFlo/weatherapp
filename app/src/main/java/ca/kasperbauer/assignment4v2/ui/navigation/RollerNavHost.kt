package ca.kasperbauer.assignment4v2.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

import ca.kasperbauer.assignment4v2.ui.traf.TrafScreen
import ca.kasperbauer.assignment4v2.ui.traf.TrafViewModel

import ca.kasperbauer.assignment4v2.ui.davis.DavisScreen
import ca.kasperbauer.assignment4v2.ui.davis.DavisViewModel

import ca.kasperbauer.assignment4v2.ui.HMC.HMCScreen
import ca.kasperbauer.assignment4v2.ui.HMC.HMCViewModel


@Composable
fun RollerNavHost(navController: NavHostController){
    NavHost(navController, startDestination = HMCDestination.route){

        composable(route = HMCDestination.route){
            val viewModel: HMCViewModel = hiltViewModel()
            HMCScreen(
                viewModel = viewModel,
                onTabPressed = tabNavigate(navController)
            )
        }

        composable(route = TrafDestination.route){
            val viewModel: TrafViewModel = hiltViewModel()
            TrafScreen(
                viewModel = viewModel,
                onTabPressed = tabNavigate(navController),
                navigateBack = { navController.popBackStack() }
            )
        }

        composable(route = DavisDestination.route){
            val viewModel: DavisViewModel = hiltViewModel()
            DavisScreen(
                viewModel = viewModel,
                onTabPressed = tabNavigate(navController),
                navigateBack = { navController.popBackStack() }
            )
        }
    }
}

@Composable
private fun tabNavigate(navController: NavHostController): (String) -> Unit = { route: String ->
    if (route == HMCDestination.route) {
        navController.popBackStack(
            route = HMCDestination.route, inclusive = false
        )
    } else {
        navController.navigate(route)
    }
}