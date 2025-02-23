package ru.syndicate.atmosphere.feature.weather_detail.domain.model

internal data class WeatherDetail(
    val temperatureInfo: TemperatureInfo = TemperatureInfo(),
    val precipitationInfo: PrecipitationInfo = PrecipitationInfo(),
    val windInfo: WindInfo = WindInfo(),
    val sunInfo: SunInfo = SunInfo(),
    val weatherCode: Int = 1
)