package ca.kasperbauer.assignment4v2.uicm

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
class HMCViewModel @Inject constructor(
    private val weatherApi: WeatherApi
) : ViewModel() {

    private val _weatherState: MutableStateFlow<Pair<Double, String>?> = MutableStateFlow(null)
    val weatherState: StateFlow<Pair<Double, String>?> = _weatherState

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorState: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val errorState: StateFlow<Boolean> = _errorState

    fun fetchWeatherData() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val weatherData = weatherApi.getWeather("Mississauga,ca", "metric", "017f04360d19b1fcc3ca93c3594269e0")
                val temperature = weatherData.main.temp
                val weatherCondition = weatherData.weather.firstOrNull()?.main ?: ""
                _weatherState.value = temperature to weatherCondition
                _isLoading.value = false
            } catch (e: Exception) {
                _errorState.value = true // Set error state to true
                _weatherState.value = null
                _isLoading.value = false
            }
        }
    }
}