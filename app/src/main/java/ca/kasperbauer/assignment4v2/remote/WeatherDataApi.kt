package ca.kasperbauer.assignment4v2.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather")
    suspend fun getWeather(
        @Query("q") location: String,
        @Query("units") units: String,
        @Query("appid") apiKey: String
    ): WeatherData
}
