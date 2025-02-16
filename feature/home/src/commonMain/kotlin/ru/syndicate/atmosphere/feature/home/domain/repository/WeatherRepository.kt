package ru.syndicate.atmosphere.feature.home.domain.repository

import com.skydoves.sandwich.ApiResponse
import ru.syndicate.atmosphere.feature.home.domain.model.WeatherInfo

internal interface WeatherRepository {
    suspend fun getHourlyWeather(
        latitude: Double,
        longitude: Double,
        timeZone: String
    ): ApiResponse<WeatherInfo>
}