package ru.syndicate.atmosphere.widget.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class WeatherWidgetInfoDTO(
    @SerialName("current_temperature") val currentTemperature: Int,
    @SerialName("max_temperature") val maxTemperature: Int,
    @SerialName("min_temperature") val minTemperature: Int,
    @SerialName("weather_code") val weatherCode: Int,
    @SerialName("is_day") val isDay: Boolean,
    @SerialName("last_update_date_time") val lastUpdateDateTime: String,
    @SerialName("app_language") val appLanguage: String,
    @SerialName("is_error") val isError: Boolean
)