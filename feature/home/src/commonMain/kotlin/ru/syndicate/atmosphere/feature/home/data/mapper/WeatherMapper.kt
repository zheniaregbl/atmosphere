package ru.syndicate.atmosphere.feature.home.data.mapper

import ru.syndicate.atmosphere.feature.home.data.dto.CurrentParametersDTO
import ru.syndicate.atmosphere.feature.home.domain.model.CurrentWeatherParameters

fun CurrentParametersDTO.toCurrentWeatherParameters(): CurrentWeatherParameters {
    return CurrentWeatherParameters(
        temperature, humidity, apparentTemperature, isDay, weatherCode, pressure,
        windSpeed, windDirection
    )
}