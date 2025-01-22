package ru.syndicate.atmosphere.feature.home.data.network

import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.ktor.getApiResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.parameter
import ru.syndicate.atmosphere.feature.home.data.dto.HourlyWeatherResponseDTO

private const val BASE_URL = "https://api.open-meteo.com/v1/forecast"

internal class KtorRemoteWeatherDataSource(
    private val httpClient: HttpClient
): RemoteWeatherDataSource {

    override suspend fun getHourlyWeather(
        latitude: Double,
        longitude: Double,
        timeZone: String
    ): ApiResponse<HourlyWeatherResponseDTO> {
        return httpClient.getApiResponse(BASE_URL) {
            parameter("latitude", latitude)
            parameter("longitude", longitude)
            parameter("current", "temperature_2m,relative_humidity_2m,apparent_temperature,is_day,weather_code,surface_pressure,wind_speed_10m,wind_direction_10m")
            parameter("hourly", "temperature_2m,weather_code")
            parameter("wind_speed_unit", "ms")
            parameter("timezone", timeZone)
            parameter("forecast_days", 1)
        }
    }
}