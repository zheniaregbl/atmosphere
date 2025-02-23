package ru.syndicate.atmosphere.core.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DailyParametersDTO(
    @SerialName("weather_code") val weatherCode: List<Int>,
    @SerialName("temperature_2m_max") val maxTemperature: List<Double>,
    @SerialName("temperature_2m_min") val minTemperature: List<Double>,
    @SerialName("apparent_temperature_max") val apparentMaxTemperature: List<Double>,
    @SerialName("apparent_temperature_min") val apparentMinTemperature: List<Double>,
    @SerialName("sunrise") val sunriseTime: List<String>,
    @SerialName("sunset") val sunsetTime: List<String>,
    @SerialName("daylight_duration") val daylightDuration: List<Double>,
    @SerialName("precipitation_sum") val precipitationSum: List<Double>,
    @SerialName("precipitation_hours") val precipitationHours: List<Double>,
    @SerialName("wind_speed_10m_max") val maxWindSpeed: List<Double>,
    @SerialName("wind_gusts_10m_max") val maxWindGusts: List<Double>,
    @SerialName("wind_direction_10m_dominant") val windDirection: List<Int>
)