package ru.syndicate.atmosphere.feature.home.presentation.util

import atmosphere.feature.home.generated.resources.Res
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
internal suspend fun lottieStringByWeatherCode(weatherCode: Int) = Res
    .readBytes(
        "files/" +
        when (weatherCode) {
            0 -> "sun"
            1, 2 -> "cloudy2"
            3 -> "cloudy"
            45 -> "fog"
            48 -> "sun_fog"
            in 51..67 -> "sun_rain"
            71, 73 -> "sun_snow"
            75, 77 -> "snow"
            in 80..82 -> "sun_rain"
            85, 86 -> "snow"
            in 95..99 -> "rain_light"
            else -> ""
        }
        + ".json"
    )
    .decodeToString()