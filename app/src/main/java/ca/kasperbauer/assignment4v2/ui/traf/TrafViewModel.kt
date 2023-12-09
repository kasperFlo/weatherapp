package ca.kasperbauer.assignment4v2.ui.traf

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
                val weatherData = weatherApi.getWeather("Oakville,ca", "metric", "YOUR_API_KEY_HERE")
                val temperature = weatherData.main.temp
                val weatherCondition = weatherData.weather.firstOrNull()?.main ?: ""
                _weatherState.value = temperature to weatherCondition
            } catch (e: Exception) {
                _weatherState.value = null
            }
        }
    }
}
