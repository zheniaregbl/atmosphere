package ru.syndicate.atmosphere.feature.weather_detail.domain.repository

import com.skydoves.sandwich.ApiResponse
import ru.syndicate.atmosphere.feature.weather_detail.domain.model.WeatherDetail

internal interface WeatherRepository {
    suspend fun getDailyWeather(
        latitude: Double,
        longitude: Double,
        timeZone: String
    ): ApiResponse<WeatherDetail>
}