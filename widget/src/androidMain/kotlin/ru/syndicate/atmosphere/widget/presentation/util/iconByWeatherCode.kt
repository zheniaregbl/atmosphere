package ru.syndicate.atmosphere.widget.presentation.util

import ru.syndicate.atmosphere.widget.R

internal fun iconByWeatherCode(weatherCode: Int) = when (weatherCode) {
    0 -> R.drawable.sun_svg
    1 -> R.drawable.light_cloudy_svg
    2 -> R.drawable.middle_cloudy_svg
    3 -> R.drawable.cloudy_svg
    45, 48 -> R.drawable.fog_svg
    51, 56 -> R.drawable.light_drizzle_svg
    53, 55, 57 -> R.drawable.drizzle_svg
    61, 66 -> R.drawable.light_rain_svg
    63 -> R.drawable.middle_rain_svg
    65, 67 -> R.drawable.rain_svg
    71 -> R.drawable.light_snow_svg
    73 -> R.drawable.middle_snow_svg
    75 -> R.drawable.heavy_snow_svg
    77 -> R.drawable.snow_grains_svg
    in 80..82 -> R.drawable.rain_shower_svg
    85 -> R.drawable.snow_shower_svg
    86 -> R.drawable.heavy_snow_shower_svg
    in 95..99 -> R.drawable.thunderstorm_svg
    else -> R.drawable.sun_svg
}