package ru.syndicate.atmosphere.feature.home.presentation.translation.string

internal data class Strings(
    val screenTitle: String,
    val errorStrings: ErrorStrings,
    val windTitle: String,
    val windUnit: String,
    val humidityTitle: String,
    val hourlyForecast: String,
    val feelingTempTitle: String,
    val hugeDiffTempText: String,
    val smallDiffTempText: String,
    val noDiffTempText: String,
    val weatherDescTitle: String,
    val detailForecastTitle: String,
    val detailForecastDesc: String,
    val someDayForecastTitle: String,
    val someDayForecastDesc: String,
    val weatherText: WeatherText
)

internal data class WeatherText(
    val clearSky: Pair<String, String>,
    val mainlyClear: Pair<String, String>,
    val partlyCloudy: Pair<String, String>,
    val overcast: Pair<String, String>,
    val fog: Pair<String, String>,
    val lightDrizzle: Pair<String, String>,
    val moderateDrizzle: Pair<String, String>,
    val heavyDrizzle: Pair<String, String>,
    val lightFreezingDrizzle: Pair<String, String>,
    val heavyFreezingDrizzle: Pair<String, String>,
    val slightRain: Pair<String, String>,
    val moderateRain: Pair<String, String>,
    val heavyRain: Pair<String, String>,
    val lightFreezingRain: Pair<String, String>,
    val heavyFreezingRain: Pair<String, String>,
    val slightSnowFall: Pair<String, String>,
    val moderateSnowFall: Pair<String, String>,
    val heavySnowFall: Pair<String, String>,
    val snowGrains: Pair<String, String>,
    val slightRainShower: Pair<String, String>,
    val moderateRainShower: Pair<String, String>,
    val violentRainShower: Pair<String, String>,
    val slightSnowShower: Pair<String, String>,
    val heavySnowShower: Pair<String, String>,
    val thunderstorm: Pair<String, String>
)

internal data class ErrorStrings(
    val dialogTitle: String,
    val exception: String,
    val error: String
)