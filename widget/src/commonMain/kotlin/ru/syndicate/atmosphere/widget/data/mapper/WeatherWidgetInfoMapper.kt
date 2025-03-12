package ru.syndicate.atmosphere.widget.data.mapper

import ru.syndicate.atmosphere.widget.data.dto.WeatherWidgetInfoDTO
import ru.syndicate.atmosphere.widget.domain.model.WeatherWidgetInfo

internal fun WeatherWidgetInfoDTO.toModel() =
    WeatherWidgetInfo(
        currentTemperature,
        maxTemperature,
        minTemperature,
        weatherCode,
        lastUpdateDateTime,
        appLanguage,
        isError
    )

internal fun WeatherWidgetInfo.toDTO() =
    WeatherWidgetInfoDTO(
        currentTemperature,
        maxTemperature,
        minTemperature,
        weatherCode,
        lastUpdateDateTime,
        appLanguage,
        isError
    )