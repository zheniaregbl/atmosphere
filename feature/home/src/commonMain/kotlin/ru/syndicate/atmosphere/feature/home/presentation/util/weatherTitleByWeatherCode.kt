package ru.syndicate.atmosphere.feature.home.presentation.util

import androidx.compose.runtime.Composable
import ru.syndicate.atmosphere.feature.home.presentation.translation.util.LocalHomeStrings

@Composable
internal fun weatherTitleByWeatherCode(weatherCode: Int) = when(weatherCode) {
    0 -> LocalHomeStrings.current.weatherText.clearSky.first
    1 -> LocalHomeStrings.current.weatherText.mainlyClear.first
    2 -> LocalHomeStrings.current.weatherText.partlyCloudy.first
    3 -> LocalHomeStrings.current.weatherText.overcast.first
    in 45..48 -> LocalHomeStrings.current.weatherText.fog.first
    51 -> LocalHomeStrings.current.weatherText.lightDrizzle.first
    53 -> LocalHomeStrings.current.weatherText.moderateDrizzle.first
    55 -> LocalHomeStrings.current.weatherText.heavyDrizzle.first
    56 -> LocalHomeStrings.current.weatherText.lightFreezingDrizzle.first
    57 -> LocalHomeStrings.current.weatherText.heavyFreezingDrizzle.first
    61 -> LocalHomeStrings.current.weatherText.slightRain.first
    63 -> LocalHomeStrings.current.weatherText.moderateRain.first
    65 -> LocalHomeStrings.current.weatherText.heavyRain.first
    66 -> LocalHomeStrings.current.weatherText.lightFreezingDrizzle.first
    67 -> LocalHomeStrings.current.weatherText.heavyFreezingDrizzle.first
    71 -> LocalHomeStrings.current.weatherText.slightSnowFall.first
    73 -> LocalHomeStrings.current.weatherText.moderateSnowFall.first
    75 -> LocalHomeStrings.current.weatherText.heavySnowFall.first
    77 -> LocalHomeStrings.current.weatherText.snowGrains.first
    80 -> LocalHomeStrings.current.weatherText.slightRainShower.first
    81 -> LocalHomeStrings.current.weatherText.moderateRainShower.first
    82 -> LocalHomeStrings.current.weatherText.violentRainShower.first
    85 -> LocalHomeStrings.current.weatherText.slightSnowShower.first
    86 -> LocalHomeStrings.current.weatherText.heavySnowShower.first
    in 95..99 -> LocalHomeStrings.current.weatherText.thunderstorm.first
    else -> ""
}