package ru.syndicate.atmosphere.core.data.network

import com.skydoves.sandwich.ApiResponse
import ru.syndicate.atmosphere.core.data.dto.DailyWeatherResponseDTO
import ru.syndicate.atmosphere.core.data.dto.HourlyWeatherResponseDTO

interface RemoteWeatherDataSource {

    suspend fun getHourlyWeather(
        latitude: Double,
        longitude: Double,
        timeZone: String
    ): ApiResponse<HourlyWeatherResponseDTO>

    suspend fun getDailyWeather(
        latitude: Double,
        longitude: Double,
        timeZone: String
    ): ApiResponse<DailyWeatherResponseDTO>
}