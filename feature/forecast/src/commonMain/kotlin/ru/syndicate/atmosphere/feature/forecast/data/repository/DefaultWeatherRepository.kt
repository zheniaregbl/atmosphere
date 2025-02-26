package ru.syndicate.atmosphere.feature.forecast.data.repository

import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.mapSuccess
import ru.syndicate.atmosphere.core.data.network.RemoteWeatherDataSource
import ru.syndicate.atmosphere.feature.forecast.data.mapper.toDailyForecast
import ru.syndicate.atmosphere.feature.forecast.domain.model.DailyForecast
import ru.syndicate.atmosphere.feature.forecast.domain.repository.WeatherRepository

internal class DefaultWeatherRepository(
    private val remoteWeatherDataSource: RemoteWeatherDataSource
): WeatherRepository {

    override suspend fun getForecastWeather(
        latitude: Double,
        longitude: Double,
        timeZone: String
    ): ApiResponse<List<DailyForecast>> {
        return remoteWeatherDataSource
            .getForecastWeather(latitude, longitude, timeZone)
            .mapSuccess { dailyParameters.toDailyForecast() }
    }
}