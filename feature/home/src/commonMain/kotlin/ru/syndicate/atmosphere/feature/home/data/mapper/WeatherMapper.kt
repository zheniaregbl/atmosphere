package ru.syndicate.atmosphere.feature.home.data.mapper

import ru.syndicate.atmosphere.core.data.dto.CurrentParametersDTO
import ru.syndicate.atmosphere.core.data.dto.HourlyParametersDTO
import ru.syndicate.atmosphere.feature.home.domain.model.CurrentWeatherParameters
import ru.syndicate.atmosphere.feature.home.domain.model.HourlyWeather

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