package ru.syndicate.atmosphere.feature.home.data.network

import ru.syndicate.atmosphere.core.domain.DataError
import ru.syndicate.atmosphere.core.domain.Result
import ru.syndicate.atmosphere.feature.home.data.dto.WeatherResponseDTO

interface RemoteWeatherDataSource {

    suspend fun getCurrentWeather(
        latitude: Double = 58.5213,
        longitude: Double = 31.271
    ): Result<WeatherResponseDTO, DataError.Remote>
}