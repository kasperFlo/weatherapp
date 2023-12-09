package ca.kasperbauer.assignment4v2.ui.traf

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import ca.kasperbauer.assignment4v2.remote.WeatherApi
import dagger.hilt.android.lifecycle.HiltViewModel
//import ca.kasperbauer.assignment4v2.remote.WeatherData

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class TrafViewModel @Inject constructor(
    private val weatherApi: WeatherApi
) : ViewModel() {

    private val _weatherState: MutableStateFlow<Pair<Double, String>?> = MutableStateFlow(null)
    val weatherState: StateFlow<Pair<Double, String>?> = _weatherState

    fun fetchWeatherData() {
        viewModelScope.launch {
            try {
                Log.d("TrafViewModel", "Fetching weather data...") // Log message before fetching

                val weatherData = weatherApi.getWeather("Oakville,ca", "metric", "017f04360d19b1fcc3ca93c3594269e0")

                Log.d("TrafViewModel", "Weather data received: $weatherData") // Log received data

                val temperature = weatherData.main.temp
                val weatherCondition = weatherData.weather.firstOrNull()?.main ?: ""
                _weatherState.value = temperature to weatherCondition
            } catch (e: Exception) {
                Log.e("TrafViewModel", "Error fetching weather data: ${e.message}", e) // Log error if any
                _weatherState.value = null
            }
        }
    }
}