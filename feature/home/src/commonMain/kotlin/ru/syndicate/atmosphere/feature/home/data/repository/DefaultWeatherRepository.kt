package ru.syndicate.atmosphere.feature.home.data.repository

import ru.syndicate.atmosphere.core.domain.DataError
import ru.syndicate.atmosphere.core.domain.Result
import ru.syndicate.atmosphere.core.domain.map
import ru.syndicate.atmosphere.feature.home.data.mapper.toCurrentWeatherParameters
import ru.syndicate.atmosphere.feature.home.data.network.RemoteWeatherDataSource
import ru.syndicate.atmosphere.feature.home.domain.model.CurrentWeatherParameters
import ru.syndicate.atmosphere.feature.home.domain.repository.WeatherRepository

class DefaultWeatherRepository(
    private val remoteWeatherDataSource: RemoteWeatherDataSource
): WeatherRepository {

    override suspend fun getCurrentWeather(): Result<CurrentWeatherParameters, DataError.Remote> {
        return remoteWeatherDataSource
            .getCurrentWeather()
            .map { dto ->
                dto
                    .currentParameters
                    .toCurrentWeatherParameters()
            }
    }
}