package ru.syndicate.atmosphere.feature.home.data.repository

import ru.syndicate.atmosphere.core.domain.DataError
import ru.syndicate.atmosphere.core.domain.Result
import ru.syndicate.atmosphere.core.domain.map
import ru.syndicate.atmosphere.feature.home.data.mapper.toCurrentWeatherParameters
import ru.syndicate.atmosphere.feature.home.data.mapper.toHourlyWeather
import ru.syndicate.atmosphere.feature.home.data.network.RemoteWeatherDataSource
import ru.syndicate.atmosphere.feature.home.domain.model.CurrentWeatherParameters
import ru.syndicate.atmosphere.feature.home.domain.model.HourlyWeather
import ru.syndicate.atmosphere.feature.home.domain.model.WeatherInfo
import ru.syndicate.atmosphere.feature.home.domain.repository.WeatherRepository

class DefaultWeatherRepository(
    private val remoteWeatherDataSource: RemoteWeatherDataSource
): WeatherRepository {

    override suspend fun getHourlyWeather(): Result<WeatherInfo, DataError.Remote> {
        return remoteWeatherDataSource
            .getHourlyWeather()
            .map { dto ->

                WeatherInfo(
                    currentWeatherParameters = dto.currentParameters.toCurrentWeatherParameters(),
                    hourlyWeather = dto.hourlyParameters.toHourlyWeather()
                )
            }
    }
}