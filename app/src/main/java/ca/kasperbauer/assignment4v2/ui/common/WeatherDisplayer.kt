package ca.kasperbauer.assignment4v2.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.kasperbauer.assignment4v2.R

@Composable
fun DisplayWeather(weatherData: Pair<Double, String>) {
    WeatherImage(weatherCondition = weatherData.second)
    Text(
        text = "Temperature: ${weatherData.first} C",
        fontSize = 24.sp,
        modifier = Modifier.padding(bottom = 16.dp)
    )
}

@Composable
fun DisplayDefaultText() {
    Text(
        text = stringResource(R.string.nav_Trafalgar_title),
        fontSize = 24.sp,
        modifier = Modifier.padding(bottom = 16.dp)
    )
}

@Composable
fun WeatherImage(weatherCondition: String) {
    val drawableResource = when (weatherCondition) {
        "clear" -> R.drawable.art_clear
        "clouds" -> R.drawable.art_clouds
        "fog" -> R.drawable.art_fog
        "light_clouds" -> R.drawable.art_light_clouds
        "light_rain" -> R.drawable.art_light_rain
        "rain" -> R.drawable.art_rain

        else -> R.drawable.art_clear // Set a default image if the condition doesn't match
    }
    Image(
        painter = painterResource(id = drawableResource),
        contentDescription = null, // Provide content description as needed
        modifier = Modifier.size(300.dp) // Set the desired size for the image
    )
}