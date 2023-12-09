package ca.kasperbauer.assignment4v2.ui.davis


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import ca.kasperbauer.assignment4v2.ui.common.BottomBar
import ca.kasperbauer.assignment4v2.ui.common.DisplayDefaultText
import ca.kasperbauer.assignment4v2.ui.common.DisplayWeather
import ca.kasperbauer.assignment4v2.ui.common.TopAppBar
import ca.kasperbauer.assignment4v2.ui.common.WeatherFetchButton
import ca.kasperbauer.assignment4v2.ui.navigation.DavisDestination



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DavisScreen(
    viewModel: DavisViewModel,
    onTabPressed: (String) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val weatherState = viewModel.weatherState.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    Scaffold(modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = stringResource(DavisDestination.titleRes),
                canNavigateBack = true,
                navigateUp = navigateBack,
                scrollBehavior = scrollBehavior
            )
        },
        bottomBar = {
            BottomBar(
                currentRoute = DavisDestination.route,
                onTabPressed = onTabPressed
            )
        }
    ) { innerPadding ->
        Box(
            contentAlignment = Alignment.Center, // Center content horizontally and vertically
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize() // Fill the entire available space
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                val weatherData = weatherState.value
                if (weatherData != null) {
                    DisplayWeather(weatherData)
                } else {
                    DisplayDefaultText("davis")
                }
                WeatherFetchButton(isLoading, viewModel::fetchWeatherData)
            }
        }
    }
}
