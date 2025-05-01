package ru.syndicate.atmosphere.feature.weather_detail.data.mapper

import kotlinx.datetime.LocalDateTime
import ru.syndicate.atmosphere.core.data.dto.DailyDetailWeatherResponseDTO
import ru.syndicate.atmosphere.feature.weather_detail.domain.model.PrecipitationInfo
import ru.syndicate.atmosphere.feature.weather_detail.domain.model.PressureInfo
import ru.syndicate.atmosphere.feature.weather_detail.domain.model.SunInfo
import ru.syndicate.atmosphere.feature.weather_detail.domain.model.TemperatureInfo
import ru.syndicate.atmosphere.feature.weather_detail.domain.model.WeatherDetail
import ru.syndicate.atmosphere.feature.weather_detail.domain.model.WindInfo
import kotlin.math.roundToInt

internal fun DailyDetailWeatherResponseDTO.toWeatherDetail(): WeatherDetail {
    return WeatherDetail(
        temperatureInfo = TemperatureInfo(
            maxTemperature = this.dailyParameters.maxTemperature[1].roundToInt(),
            maxApparentTemperature = this.dailyParameters.apparentMaxTemperature[1].roundToInt(),
            minTemperature = this.dailyParameters.minTemperature[1].roundToInt(),
            minApparentTemperature = this.dailyParameters.apparentMinTemperature[1].roundToInt(),
            temperatures = this.hourlyDayParameters.temperatures
                .dropLast(24).takeLast(24).map { it.toInt() }
        ),
        precipitationInfo = PrecipitationInfo(
            hours = this.dailyParameters.precipitationHours[1].toInt(),
            sum = this.dailyParameters.precipitationSum[1],
            probabilities = this.hourlyDayParameters.precipitationProbability
                .dropLast(24).takeLast(24).map { it.toInt() }
        ),
        windInfo = WindInfo(
            maxSpeed = this.dailyParameters.maxWindSpeed[1].toInt(),
            maxGusts = this.dailyParameters.maxWindGusts[1].toInt(),
            direction = this.dailyParameters.windDirection[1]
        ),
        sunInfo = SunInfo(
            sunrise = LocalDateTime.parse(this.dailyParameters.sunriseTime[1]),
            nextDaySunrise = LocalDateTime.parse(this.dailyParameters.sunriseTime.last()),
            previousDaySunset = LocalDateTime.parse(this.dailyParameters.sunsetTime.first()),
            sunset = LocalDateTime.parse(this.dailyParameters.sunsetTime[1]),
            daylightDuration = this.dailyParameters.daylightDuration[1].toInt() / 3600
        ),
        pressureInfo = PressureInfo(
            mean = this.dailyParameters.meanPressure[1],
            max = this.dailyParameters.maxPressure[1],
            min = this.dailyParameters.minPressure[1]
        ),
        weatherCode = this.dailyParameters.weatherCode[1]
    )
}