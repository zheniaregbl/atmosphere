package ru.syndicate.atmosphere.feature.home.presentation.util

import atmosphere.feature.home.generated.resources.Res
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
internal suspend fun lottieStringByWeatherCode(weatherCode: Int, isDay: Boolean = true) = Res
    .readBytes(
        "files/" +
        when (weatherCode) {
            0 -> if (isDay) "sun" else "moon"
            1, 2 -> if (isDay) "cloudy2" else "moon_cloudy"
            3 -> "cloudy"
            45, 48 -> "fog"
            in 51..67 -> if (isDay) "sun_rain" else "moon_rain"
            71, 73 -> if (isDay) "sun_snow" else "moon_snow"
            75, 77 -> "snow"
            in 80..82 -> if (isDay) "sun_rain" else "moon_rain"
            85, 86 -> "snow"
            in 95..99 -> "rain_light"
            else -> ""
        }
        + ".json"
    )
    .decodeToString()