package ru.syndicate.atmosphere.feature.home.data.network

import ru.syndicate.atmosphere.core.domain.DataError
import ru.syndicate.atmosphere.core.domain.Result
import ru.syndicate.atmosphere.feature.home.data.dto.HourlyWeatherResponseDTO

internal interface RemoteWeatherDataSource {

    suspend fun getHourlyWeather(
        latitude: Double,
        longitude: Double,
        timeZone: String
    ): Result<HourlyWeatherResponseDTO, DataError.Remote>
}