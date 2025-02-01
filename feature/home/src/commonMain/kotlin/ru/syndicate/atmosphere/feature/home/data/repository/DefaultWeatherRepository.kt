package ru.syndicate.atmosphere.feature.home.data.repository

import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.mapSuccess
import ru.syndicate.atmosphere.feature.home.data.mapper.toCurrentWeatherParameters
import ru.syndicate.atmosphere.feature.home.data.mapper.toHourlyWeather
import ru.syndicate.atmosphere.feature.home.data.network.RemoteWeatherDataSource
import ru.syndicate.atmosphere.feature.home.domain.model.WeatherInfo
import ru.syndicate.atmosphere.feature.home.domain.repository.WeatherRepository

internal class DefaultWeatherRepository(
    private val remoteWeatherDataSource: RemoteWeatherDataSource,
): WeatherRepository {

    override suspend fun getHourlyWeather(
        latitude: Double,
        longitude: Double,
        timeZone: String
    ): ApiResponse<WeatherInfo> {
        return remoteWeatherDataSource
            .getHourlyWeather(latitude, longitude, timeZone)
            .mapSuccess {
                WeatherInfo(
                    currentWeatherParameters = currentParameters
                        .toCurrentWeatherParameters(),
                    hourlyWeather = hourlyParameters.toHourlyWeather()
                )
            }
    }
}