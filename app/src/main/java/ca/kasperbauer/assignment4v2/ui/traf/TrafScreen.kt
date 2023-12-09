package ca.kasperbauer.assignment4v2.ui.traf

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.kasperbauer.assignment4v2.R
import ca.kasperbauer.assignment4v2.ui.common.BottomBar
import ca.kasperbauer.assignment4v2.ui.common.TopAppBar
import ca.kasperbauer.assignment4v2.ui.navigation.TrafDestination

import ca.kasperbauer.assignment4v2.ui.common.WeatherFetchButton
import ca.kasperbauer.assignment4v2.ui.common.DisplayWeather
import ca.kasperbauer.assignment4v2.ui.common.DisplayDefaultText


import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrafScreen(
    viewModel: TrafViewModel,
    onTabPressed: (String) -> Unit,
    modifier: Modifier = Modifier
){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val weatherState = viewModel.weatherState.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

//    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
//    val weatherState by remember { viewModel.weatherState.collectAsState() }


    Scaffold(modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = stringResource(TrafDestination.titleRes),
                canNavigateBack = false,
                scrollBehavior = scrollBehavior
            )
        },
        bottomBar = {
            BottomBar(
                currentRoute = TrafDestination.route,
                onTabPressed = onTabPressed
            )
        }
    ) { innerPadding ->

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
        ) {
            val weatherData = weatherState.value
            if (weatherData != null) {
                DisplayWeather(weatherData)
            } else {
                DisplayDefaultText()
            }

            WeatherFetchButton(isLoading, viewModel::fetchWeatherData)
        }
    }
}

//@Composable
//private fun WeatherFetchButton(
//    isLoading: Boolean,
//    onFetchClicked: () -> Unit
//    ) {
//    Button(
//        onClick = { onFetchClicked() },
//        modifier = Modifier.padding(top = 16.dp)
//    ) {
//        Text(text = if (isLoading) "Loading..." else "Fetch Weather")
//    }
//}
//@Composable
//private fun DisplayWeather(weatherData: Pair<Double, String>) {
//    WeatherImage(weatherCondition = weatherData.second)
//    Text(
//        text = "Temperature: ${weatherData.first} C",
//        fontSize = 24.sp,
//        modifier = Modifier.padding(bottom = 16.dp)
//    )
//}
//
//@Composable
//private fun DisplayDefaultText() {
//    Text(
//        text = stringResource(R.string.nav_Trafalgar_title),
//        fontSize = 24.sp,
//        modifier = Modifier.padding(bottom = 16.dp)
//    )
//}
//
//@Composable
//fun WeatherImage(weatherCondition: String) {
//    val drawableResource = when (weatherCondition) {
//        "clear" -> R.drawable.art_clear
//        "clouds" -> R.drawable.art_clouds
//        "fog" -> R.drawable.art_fog
//        "light_clouds" -> R.drawable.art_light_clouds
//        "light_rain" -> R.drawable.art_light_rain
//        "rain" -> R.drawable.art_rain
//
//        else -> R.drawable.art_clear // Set a default image if the condition doesn't match
//    }
//    Image(
//        painter = painterResource(id = drawableResource),
//        contentDescription = null, // Provide content description as needed
//        modifier = Modifier.size(300.dp) // Set the desired size for the image
//    )
//}
