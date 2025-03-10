package ru.syndicate.atmosphere.core.data.network

import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.ktor.getApiResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.parameter
import ru.syndicate.atmosphere.core.data.dto.DailyDetailWeatherResponseDTO
import ru.syndicate.atmosphere.core.data.dto.DailyForecastWeatherResponseDTO
import ru.syndicate.atmosphere.core.data.dto.HourlyWeatherResponseDTO
import ru.syndicate.atmosphere.core.data.dto.WidgetWeatherDTO

private const val BASE_URL = "https://api.open-meteo.com/v1/forecast"

data class KtorRemoteWeatherDataSource(
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

    override suspend fun getDailyWeather(
        latitude: Double,
        longitude: Double,
        timeZone: String
    ): ApiResponse<DailyDetailWeatherResponseDTO> {
        return httpClient.getApiResponse(BASE_URL) {
            parameter("latitude", latitude)
            parameter("longitude", longitude)
            parameter("hourly", "temperature_2m,precipitation_probability")
            parameter("daily", "weather_code,temperature_2m_max,temperature_2m_min,apparent_temperature_max,apparent_temperature_min,sunrise,sunset,daylight_duration,precipitation_probability_max,precipitation_sum,rain_sum,showers_sum,snowfall_sum,precipitation_hours,wind_speed_10m_max,wind_gusts_10m_max,wind_direction_10m_dominant")
            parameter("wind_speed_unit", "ms")
            parameter("timezone", timeZone)
            parameter("forecast_days", 1)
        }
    }

    override suspend fun getForecastWeather(
        latitude: Double,
        longitude: Double,
        timeZone: String
    ): ApiResponse<DailyForecastWeatherResponseDTO> {
        return httpClient.getApiResponse(BASE_URL) {
            parameter("latitude", latitude)
            parameter("longitude", longitude)
            parameter("daily", "weather_code,temperature_2m_max,temperature_2m_min,apparent_temperature_max,apparent_temperature_min,sunrise,sunset,daylight_duration,precipitation_probability_max,precipitation_sum,rain_sum,showers_sum,snowfall_sum,precipitation_hours,wind_speed_10m_max,wind_gusts_10m_max,wind_direction_10m_dominant")
            parameter("wind_speed_unit", "ms")
            parameter("timezone", timeZone)
            parameter("forecast_days", 8)
        }
    }

    override suspend fun getWidgetWeather(
        latitude: Double,
        longitude: Double,
        timeZone: String
    ): ApiResponse<WidgetWeatherDTO> {
        return httpClient.getApiResponse(BASE_URL) {
            parameter("latitude", latitude)
            parameter("longitude", longitude)
            parameter("current", "temperature_2m,relative_humidity_2m,apparent_temperature,is_day,weather_code,surface_pressure,wind_speed_10m,wind_direction_10m")
            parameter("daily", "weather_code,temperature_2m_max,temperature_2m_min,apparent_temperature_max,apparent_temperature_min,sunrise,sunset,daylight_duration,precipitation_probability_max,precipitation_sum,rain_sum,showers_sum,snowfall_sum,precipitation_hours,wind_speed_10m_max,wind_gusts_10m_max,wind_direction_10m_dominant")
            parameter("wind_speed_unit", "ms")
            parameter("timezone", timeZone)
            parameter("forecast_days", 1)
        }
    }
}