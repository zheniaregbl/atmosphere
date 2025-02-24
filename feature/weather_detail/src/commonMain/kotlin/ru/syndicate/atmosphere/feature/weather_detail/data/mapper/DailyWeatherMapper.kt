package ru.syndicate.atmosphere.feature.weather_detail.data.mapper

import kotlinx.datetime.LocalDateTime
import ru.syndicate.atmosphere.core.data.dto.DailyWeatherResponseDTO
import ru.syndicate.atmosphere.feature.weather_detail.domain.model.PrecipitationInfo
import ru.syndicate.atmosphere.feature.weather_detail.domain.model.SunInfo
import ru.syndicate.atmosphere.feature.weather_detail.domain.model.TemperatureInfo
import ru.syndicate.atmosphere.feature.weather_detail.domain.model.WeatherDetail
import ru.syndicate.atmosphere.feature.weather_detail.domain.model.WindInfo

internal fun DailyWeatherResponseDTO.toWeatherDetail(): WeatherDetail {
    return WeatherDetail(
        temperatureInfo = TemperatureInfo(
            maxTemperature = this.dailyParameters.maxTemperature.first().toInt(),
            maxApparentTemperature = this.dailyParameters.apparentMaxTemperature.first().toInt(),
            minTemperature = this.dailyParameters.minTemperature.first().toInt(),
            minApparentTemperature = this.dailyParameters.apparentMinTemperature.first().toInt(),
            temperatures = this.hourlyDayParameters.temperatures.map { it.toInt() }
        ),
        precipitationInfo = PrecipitationInfo(
            hours = this.dailyParameters.precipitationHours.first().toInt(),
            sum = this.dailyParameters.precipitationSum.first(),
            probabilities = this.hourlyDayParameters.precipitationProbability.map { it.toInt() }
        ),
        windInfo = WindInfo(
            maxSpeed = this.dailyParameters.maxWindSpeed.first().toInt(),
            maxGusts = this.dailyParameters.maxWindGusts.first().toInt(),
            direction = this.dailyParameters.windDirection.first()
        ),
        sunInfo = SunInfo(
            sunrise = LocalDateTime.parse(this.dailyParameters.sunriseTime.first()).time,
            sunset = LocalDateTime.parse(this.dailyParameters.sunsetTime.first()).time,
            daylightDuration = this.dailyParameters.daylightDuration.first().toInt() / 3600
        ),
        weatherCode = this.dailyParameters.weatherCode.first()
    )
}