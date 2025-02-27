package ru.syndicate.atmosphere.feature.forecast.data.mapper

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import ru.syndicate.atmosphere.core.data.dto.DailyParametersDTO
import ru.syndicate.atmosphere.feature.forecast.domain.model.DailyForecast

internal fun DailyParametersDTO.toDailyForecast() =
    this.time.mapIndexed { index, time ->
        DailyForecast(
            date = LocalDate.parse(time),
            maxTemperature = this.maxTemperature[index].toInt(),
            minTemperature = this.minTemperature[index].toInt(),
            sunrise = LocalDateTime.parse(this.sunriseTime[index]).time,
            sunset = LocalDateTime.parse(this.sunsetTime[index]).time,
            maxWindSpeed = this.maxWindSpeed[index].toInt(),
            precipitationProbability = this.precipitationProbability[index],
            weatherCode = this.weatherCode[index]
        )
    }.takeLast(7)