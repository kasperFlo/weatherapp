package ca.kasperbauer.assignment4v2.ui.davis

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
class DavisViewModel @Inject constructor(
    private val weatherApi: WeatherApi
) : ViewModel() {

    private val _weatherState: MutableStateFlow<Pair<Double, String>?> = MutableStateFlow(null)
    val weatherState: StateFlow<Pair<Double, String>?> = _weatherState

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun fetchWeatherData() {
        viewModelScope.launch {
            try {
                _isLoading.value = true // S

                val weatherData = weatherApi.getWeather("Brampton,ca", "metric", "017f04360d19b1fcc3ca93c3594269e0")

                val temperature = weatherData.main.temp
                val weatherCondition = weatherData.weather.firstOrNull()?.main ?: ""
                _weatherState.value = temperature to weatherCondition
                _isLoading.value = false
            } catch (e: Exception) {

                _weatherState.value = null
                _isLoading.value = false

            }
        }
    }
}