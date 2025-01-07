package ru.syndicate.atmosphere.feature.home.presentation.util

import atmosphere.feature.home.generated.resources.Res
import atmosphere.feature.home.generated.resources.cloudy_svg
import atmosphere.feature.home.generated.resources.drizzle_svg
import atmosphere.feature.home.generated.resources.fog_svg
import atmosphere.feature.home.generated.resources.heavy_snow_shower_svg
import atmosphere.feature.home.generated.resources.heavy_snow_svg
import atmosphere.feature.home.generated.resources.light_cloudy_svg
import atmosphere.feature.home.generated.resources.light_drizzle_svg
import atmosphere.feature.home.generated.resources.light_rain_svg
import atmosphere.feature.home.generated.resources.light_snow_svg
import atmosphere.feature.home.generated.resources.middle_cloudy_svg
import atmosphere.feature.home.generated.resources.middle_rain_svg
import atmosphere.feature.home.generated.resources.middle_snow_svg
import atmosphere.feature.home.generated.resources.rain_shower_svg
import atmosphere.feature.home.generated.resources.rain_svg
import atmosphere.feature.home.generated.resources.snow_grains_svg
import atmosphere.feature.home.generated.resources.snow_shower_svg
import atmosphere.feature.home.generated.resources.sun_svg
import atmosphere.feature.home.generated.resources.thunderstorm_svg

fun iconByWeatherCode(weatherCode: Int) = when (weatherCode) {
    0 -> Res.drawable.sun_svg
    1 -> Res.drawable.light_cloudy_svg
    2 -> Res.drawable.middle_cloudy_svg
    3 -> Res.drawable.cloudy_svg
    45, 48 -> Res.drawable.fog_svg
    51, 56 -> Res.drawable.light_drizzle_svg
    53, 55, 57 -> Res.drawable.drizzle_svg
    61, 66 -> Res.drawable.light_rain_svg
    63 -> Res.drawable.middle_rain_svg
    65, 67 -> Res.drawable.rain_svg
    71 -> Res.drawable.light_snow_svg
    73 -> Res.drawable.middle_snow_svg
    75 -> Res.drawable.heavy_snow_svg
    77 -> Res.drawable.snow_grains_svg
    in 80..82 -> Res.drawable.rain_shower_svg
    85 -> Res.drawable.snow_shower_svg
    86 -> Res.drawable.heavy_snow_shower_svg
    in 95..99 -> Res.drawable.thunderstorm_svg
    else -> Res.drawable.sun_svg
}