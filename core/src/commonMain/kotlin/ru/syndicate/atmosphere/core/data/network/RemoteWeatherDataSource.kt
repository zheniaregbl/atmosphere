package ru.syndicate.atmosphere.core.data.network

import com.skydoves.sandwich.ApiResponse
import ru.syndicate.atmosphere.core.data.dto.DailyDetailWeatherResponseDTO
import ru.syndicate.atmosphere.core.data.dto.DailyForecastWeatherResponseDTO
import ru.syndicate.atmosphere.core.data.dto.HourlyWeatherResponseDTO
import ru.syndicate.atmosphere.core.data.dto.WidgetWeatherDTO

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
    ): ApiResponse<DailyDetailWeatherResponseDTO>

    suspend fun getForecastWeather(
        latitude: Double,
        longitude: Double,
        timeZone: String
    ): ApiResponse<DailyForecastWeatherResponseDTO>

    suspend fun getWidgetWeather(
        latitude: Double,
        longitude: Double,
        timeZone: String
    ): ApiResponse<WidgetWeatherDTO>
}