package ru.syndicate.atmosphere.feature.home.domain.repository

import ru.syndicate.atmosphere.core.domain.DataError
import ru.syndicate.atmosphere.core.domain.Result
import ru.syndicate.atmosphere.feature.home.domain.model.CurrentWeatherParameters
import ru.syndicate.atmosphere.feature.home.domain.model.HourlyWeather

interface WeatherRepository {
    suspend fun getCurrentWeather(): Result<CurrentWeatherParameters, DataError.Remote>
    suspend fun getHourlyWeather(): Result<HourlyWeather, DataError.Remote>
}