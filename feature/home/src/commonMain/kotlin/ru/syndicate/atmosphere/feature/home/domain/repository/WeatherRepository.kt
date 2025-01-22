package ru.syndicate.atmosphere.feature.home.domain.repository

import com.skydoves.sandwich.ApiResponse
import kotlinx.coroutines.flow.Flow
import ru.syndicate.atmosphere.core.domain.model.CurrentLocation
import ru.syndicate.atmosphere.feature.home.domain.model.WeatherInfo

internal interface WeatherRepository {
    val currentLocation: Flow<CurrentLocation>
    suspend fun getHourlyWeather(
        latitude: Double,
        longitude: Double,
        timeZone: String
    ): ApiResponse<WeatherInfo>
}