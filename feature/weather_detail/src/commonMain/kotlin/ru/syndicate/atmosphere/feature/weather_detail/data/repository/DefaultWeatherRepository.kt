package ru.syndicate.atmosphere.feature.weather_detail.data.repository

import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.mapSuccess
import ru.syndicate.atmosphere.core.data.network.RemoteWeatherDataSource
import ru.syndicate.atmosphere.feature.weather_detail.data.mapper.toWeatherDetail
import ru.syndicate.atmosphere.feature.weather_detail.domain.model.WeatherDetail
import ru.syndicate.atmosphere.feature.weather_detail.domain.repository.WeatherRepository

internal class DefaultWeatherRepository(
    private val remoteWeatherDataSource: RemoteWeatherDataSource
): WeatherRepository {

    override suspend fun getDailyWeather(
        latitude: Double,
        longitude: Double,
        timeZone: String
    ): ApiResponse<WeatherDetail> {
        return remoteWeatherDataSource
            .getDailyWeather(latitude, longitude, timeZone)
            .mapSuccess { toWeatherDetail() }
    }
}