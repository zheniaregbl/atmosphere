package ru.syndicate.atmosphere.feature.home.domain.repository

import ru.syndicate.atmosphere.core.domain.DataError
import ru.syndicate.atmosphere.core.domain.Result
import ru.syndicate.atmosphere.feature.home.domain.model.CurrentWeatherParameters

interface WeatherRepository {
    suspend fun getCurrentWeather(): Result<CurrentWeatherParameters, DataError.Remote>
}