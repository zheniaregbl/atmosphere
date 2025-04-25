package ru.syndicate.atmosphere.feature.home.data.mapper

import kotlinx.datetime.LocalDateTime
import ru.syndicate.atmosphere.core.data.dto.CurrentParametersDTO
import ru.syndicate.atmosphere.core.data.dto.HourlyParametersDTO
import ru.syndicate.atmosphere.core.data.dto.SunParametersDTO
import ru.syndicate.atmosphere.feature.home.domain.model.CurrentWeatherParameters
import ru.syndicate.atmosphere.feature.home.domain.model.HourlyWeather
import ru.syndicate.atmosphere.feature.home.domain.model.SunParameters

internal fun CurrentParametersDTO.toCurrentWeatherParameters(): CurrentWeatherParameters {
    return CurrentWeatherParameters(
        temperature, humidity, apparentTemperature, isDay, weatherCode, pressure,
        windSpeed, windDirection
    )
}

internal fun HourlyParametersDTO.toHourlyWeather(): HourlyWeather {
    return HourlyWeather(
        temperatures = this.temperatures,
        weatherCodes = this.weatherCodes
    )
}

internal fun SunParametersDTO.toSunParameters(): SunParameters {
    return SunParameters(
        sunrise = LocalDateTime.parse(this.sunriseTime[0]),
        sunset = LocalDateTime.parse(this.sunsetTime[0])
    )
}