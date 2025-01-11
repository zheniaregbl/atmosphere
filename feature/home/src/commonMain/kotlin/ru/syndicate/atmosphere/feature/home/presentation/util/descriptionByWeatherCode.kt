package ru.syndicate.atmosphere.feature.home.presentation.util

import androidx.compose.runtime.Composable
import atmosphere.feature.home.generated.resources.Res
import atmosphere.feature.home.generated.resources.dense_drizzle_desc
import atmosphere.feature.home.generated.resources.dense_freezing_drizzle_desc
import atmosphere.feature.home.generated.resources.fog_desc
import atmosphere.feature.home.generated.resources.heavy_freezing_rain_desc
import atmosphere.feature.home.generated.resources.heavy_rain_desc
import atmosphere.feature.home.generated.resources.heavy_snow_shower_desc
import atmosphere.feature.home.generated.resources.heavy_snowfall_desc
import atmosphere.feature.home.generated.resources.light_drizzle_desc
import atmosphere.feature.home.generated.resources.light_freezing_drizzle_desc
import atmosphere.feature.home.generated.resources.light_freezing_rain_desc
import atmosphere.feature.home.generated.resources.mainly_clear_desc
import atmosphere.feature.home.generated.resources.moderate_drizzle_desc
import atmosphere.feature.home.generated.resources.moderate_rain_desc
import atmosphere.feature.home.generated.resources.moderate_rain_shower_desc
import atmosphere.feature.home.generated.resources.moderate_snowfall_desc
import atmosphere.feature.home.generated.resources.overcast_desc
import atmosphere.feature.home.generated.resources.partly_cloudy_desc
import atmosphere.feature.home.generated.resources.slight_rain_desc
import atmosphere.feature.home.generated.resources.slight_rain_shower_desc
import atmosphere.feature.home.generated.resources.slight_snow_shower_desc
import atmosphere.feature.home.generated.resources.slight_snowfall_desc
import atmosphere.feature.home.generated.resources.snow_grains_desc
import atmosphere.feature.home.generated.resources.sun_desc
import atmosphere.feature.home.generated.resources.thunderstorm_desc
import atmosphere.feature.home.generated.resources.thunderstorm_hail_desc
import atmosphere.feature.home.generated.resources.violent_rain_shower_desc
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun descriptionByWeatherCode(weatherCode: Int) = stringResource(
    when (weatherCode) {
        0 -> Res.string.sun_desc
        1 -> Res.string.partly_cloudy_desc
        2 -> Res.string.mainly_clear_desc
        3 -> Res.string.overcast_desc
        45, 48 -> Res.string.fog_desc
        51 -> Res.string.light_drizzle_desc
        53 -> Res.string.moderate_drizzle_desc
        55 -> Res.string.dense_drizzle_desc
        56 -> Res.string.light_freezing_drizzle_desc
        57 -> Res.string.dense_freezing_drizzle_desc
        61 -> Res.string.slight_rain_desc
        63 -> Res.string.moderate_rain_desc
        65 -> Res.string.heavy_rain_desc
        66 -> Res.string.light_freezing_rain_desc
        67 -> Res.string.heavy_freezing_rain_desc
        71 -> Res.string.slight_snowfall_desc
        73 -> Res.string.moderate_snowfall_desc
        75 -> Res.string.heavy_snowfall_desc
        77 -> Res.string.snow_grains_desc
        80 -> Res.string.slight_rain_shower_desc
        81 -> Res.string.moderate_rain_shower_desc
        82 -> Res.string.violent_rain_shower_desc
        85 -> Res.string.slight_snow_shower_desc
        86 -> Res.string.heavy_snow_shower_desc
        95 -> Res.string.thunderstorm_desc
        96, 99 -> Res.string.thunderstorm_hail_desc
        else -> Res.string.sun_desc
    }
)