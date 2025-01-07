package ru.syndicate.atmosphere.feature.home.data.mapper

import ru.syndicate.atmosphere.feature.home.data.dto.CurrentParametersDTO
import ru.syndicate.atmosphere.feature.home.data.dto.HourlyWeatherResponseDTO
import ru.syndicate.atmosphere.feature.home.domain.model.CurrentWeatherParameters
import ru.syndicate.atmosphere.feature.home.domain.model.HourlyWeather

fun CurrentParametersDTO.toCurrentWeatherParameters(): CurrentWeatherParameters {
    return CurrentWeatherParameters(
        temperature, humidity, apparentTemperature, isDay, weatherCode, pressure,
        windSpeed, windDirection
    )
}

fun HourlyWeatherResponseDTO.toHourlyWeather(): HourlyWeather {
    return HourlyWeather(
        temperatures = this.hourlyParameters.temperatures,
        weatherCodes = this.hourlyParameters.weatherCodes
    )
}