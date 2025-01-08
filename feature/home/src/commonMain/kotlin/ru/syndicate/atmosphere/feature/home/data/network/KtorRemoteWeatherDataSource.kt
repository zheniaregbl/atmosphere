package ru.syndicate.atmosphere.feature.home.data.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import ru.syndicate.atmosphere.core.data.safeCall
import ru.syndicate.atmosphere.core.domain.DataError
import ru.syndicate.atmosphere.core.domain.Result
import ru.syndicate.atmosphere.feature.home.data.dto.CurrentWeatherResponseDTO
import ru.syndicate.atmosphere.feature.home.data.dto.HourlyWeatherResponseDTO

private const val BASE_URL = "https://api.open-meteo.com/v1/forecast"

class KtorRemoteWeatherDataSource(
    private val httpClient: HttpClient
): RemoteWeatherDataSource {

    override suspend fun getCurrentWeather(
        latitude: Double,
        longitude: Double
    ): Result<CurrentWeatherResponseDTO, DataError.Remote> {
        return safeCall<CurrentWeatherResponseDTO> {
            httpClient.get(urlString = BASE_URL) {
                parameter("latitude", latitude)
                parameter("longitude", longitude)
                parameter("current", "temperature_2m,relative_humidity_2m,apparent_temperature,is_day,weather_code,surface_pressure,wind_speed_10m,wind_direction_10m")
                parameter("wind_speed_unit", "ms")
                parameter("timezone", "Europe/Moscow")
            }
        }
    }

    override suspend fun getHourlyWeather(
        latitude: Double,
        longitude: Double
    ): Result<HourlyWeatherResponseDTO, DataError.Remote> {
        return safeCall<HourlyWeatherResponseDTO> {
            httpClient.get(urlString = BASE_URL) {
                parameter("latitude", latitude)
                parameter("longitude", longitude)
                parameter("hourly", "temperature_2m,weather_code")
                parameter("timezone", "Europe/Moscow")
                parameter("forecast_days", 1)
            }
        }
    }
}