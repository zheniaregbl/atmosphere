package ru.syndicate.atmosphere.feature.forecast.data.mapper

import kotlinx.datetime.LocalDate
import ru.syndicate.atmosphere.core.data.dto.DailyParametersDTO
import ru.syndicate.atmosphere.feature.forecast.domain.model.DailyForecast

internal fun DailyParametersDTO.toDailyForecast() =
    this.time.mapIndexed { index, time ->
        DailyForecast(
            date = LocalDate.parse(time),
            maxTemperature = this.maxTemperature[index].toInt(),
            minTemperature = this.minTemperature[index].toInt(),
            weatherCode = this.weatherCode[index]
        )
    }.takeLast(7)