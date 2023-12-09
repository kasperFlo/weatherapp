package ca.kasperbauer.assignment4v2.remote
data class WeatherData(
    val main: Main,
    val weather: List<Weather>
)

data class Main(
    val temp: Double,
    val feels_like: Double
)

data class Weather(
    val main: String
)
