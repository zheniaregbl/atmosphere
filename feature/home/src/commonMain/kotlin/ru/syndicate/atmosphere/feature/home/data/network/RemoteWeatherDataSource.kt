package ru.syndicate.atmosphere.feature.home.data.network

import com.skydoves.sandwich.ApiResponse
import ru.syndicate.atmosphere.feature.home.data.dto.HourlyWeatherResponseDTO

internal interface RemoteWeatherDataSource {

    suspend fun getHourlyWeather(
        latitude: Double,
        longitude: Double,
        timeZone: String
    ): ApiResponse<HourlyWeatherResponseDTO>
}