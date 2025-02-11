package ru.syndicate.atmosphere.feature.home.presentation.util

import androidx.compose.runtime.Composable
import ru.syndicate.atmosphere.feature.home.presentation.translation.util.LocalHomeStrings

@Composable
internal fun descriptionByWeatherCode(weatherCode: Int) =
    when (weatherCode) {
        0 -> LocalHomeStrings.current.weatherText.clearSky.second
        1 -> LocalHomeStrings.current.weatherText.partlyCloudy.second
        2 -> LocalHomeStrings.current.weatherText.mainlyClear.second
        3 -> LocalHomeStrings.current.weatherText.overcast.second
        45, 48 -> LocalHomeStrings.current.weatherText.fog.second
        51 -> LocalHomeStrings.current.weatherText.lightDrizzle.second
        53 -> LocalHomeStrings.current.weatherText.moderateDrizzle.second
        55 -> LocalHomeStrings.current.weatherText.heavyDrizzle.second
        56 -> LocalHomeStrings.current.weatherText.lightFreezingDrizzle.second
        57 -> LocalHomeStrings.current.weatherText.heavyFreezingDrizzle.second
        61 -> LocalHomeStrings.current.weatherText.slightRain.second
        63 -> LocalHomeStrings.current.weatherText.moderateRain.second
        65 -> LocalHomeStrings.current.weatherText.heavyRain.second
        66 -> LocalHomeStrings.current.weatherText.lightFreezingRain.second
        67 -> LocalHomeStrings.current.weatherText.heavyFreezingRain.second
        71 -> LocalHomeStrings.current.weatherText.slightSnowFall.second
        73 -> LocalHomeStrings.current.weatherText.moderateSnowFall.second
        75 -> LocalHomeStrings.current.weatherText.heavySnowFall.second
        77 -> LocalHomeStrings.current.weatherText.snowGrains.second
        80 -> LocalHomeStrings.current.weatherText.slightRainShower.second
        81 -> LocalHomeStrings.current.weatherText.moderateRainShower.second
        82 -> LocalHomeStrings.current.weatherText.violentRainShower.second
        85 -> LocalHomeStrings.current.weatherText.slightSnowShower.second
        86 -> LocalHomeStrings.current.weatherText.heavySnowShower.second
        95 -> LocalHomeStrings.current.weatherText.thunderstorm.second
        96, 99 -> LocalHomeStrings.current.weatherText.thunderstorm.second
        else -> LocalHomeStrings.current.weatherText.clearSky.second
    }