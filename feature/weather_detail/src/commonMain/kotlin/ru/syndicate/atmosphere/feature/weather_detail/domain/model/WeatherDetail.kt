package ru.syndicate.atmosphere.feature.weather_detail.domain.model

internal data class WeatherDetail(
    val temperature: TemperatureInfo = TemperatureInfo(),
    val precipitation: PrecipitationInfo = PrecipitationInfo(),
    val wind: WindInfo = WindInfo(),
    val sunInfo: SunInfo = SunInfo(),
    val weatherCode: Int = 1
)