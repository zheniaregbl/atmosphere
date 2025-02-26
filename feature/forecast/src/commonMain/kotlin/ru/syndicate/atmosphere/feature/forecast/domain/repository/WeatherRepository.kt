package ru.syndicate.atmosphere.feature.forecast.domain.repository

import com.skydoves.sandwich.ApiResponse
import ru.syndicate.atmosphere.feature.forecast.domain.model.DailyForecast

internal interface WeatherRepository {
    suspend fun getForecastWeather(
        latitude: Double,
        longitude: Double,
        timeZone: String
    ): ApiResponse<List<DailyForecast>>
}