package ru.syndicate.atmosphere.feature.weather_detail.data.mapper

import kotlinx.datetime.LocalTime
import ru.syndicate.atmosphere.core.data.dto.DailyParametersDTO
import ru.syndicate.atmosphere.feature.weather_detail.domain.model.PrecipitationInfo
import ru.syndicate.atmosphere.feature.weather_detail.domain.model.SunInfo
import ru.syndicate.atmosphere.feature.weather_detail.domain.model.TemperatureInfo
import ru.syndicate.atmosphere.feature.weather_detail.domain.model.WeatherDetail
import ru.syndicate.atmosphere.feature.weather_detail.domain.model.WindInfo

internal fun DailyParametersDTO.toWeatherDetail(): WeatherDetail {
    return WeatherDetail(
        temperature = TemperatureInfo(
            maxTemperature = this.maxTemperature.first().toInt(),
            maxApparentTemperature = this.apparentMaxTemperature.first().toInt(),
            minTemperature = this.minTemperature.first().toInt(),
            minApparentTemperature = this.apparentMinTemperature.first().toInt()
        ),
        precipitation = PrecipitationInfo(
            hours = this.precipitationHours.first().toInt(),
            sum = this.precipitationSum.first()
        ),
        wind = WindInfo(
            maxSpeed = this.maxWindSpeed.first().toInt(),
            direction = this.windDirection.first()
        ),
        sunInfo = SunInfo(
            sunrise = LocalTime.parse(this.sunriseTime.first()),
            sunset = LocalTime.parse(this.sunsetTime.first()),
            daylightDuration = this.daylightDuration.first().toInt()
        ),
        weatherCode = this.weatherCode.first()
    )
}