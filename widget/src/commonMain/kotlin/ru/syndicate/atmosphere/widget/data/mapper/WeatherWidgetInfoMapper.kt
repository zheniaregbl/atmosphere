package ru.syndicate.atmosphere.widget.data.mapper

import ru.syndicate.atmosphere.widget.data.dto.ShortWeatherWidgetInfoDTO
import ru.syndicate.atmosphere.widget.domain.model.ShortWeatherWidgetInfo

internal fun ShortWeatherWidgetInfoDTO.toModel() =
    ShortWeatherWidgetInfo(
        currentTemperature,
        maxTemperature,
        minTemperature,
        weatherCode,
        isDay,
        lastUpdateDateTime,
        appLanguage,
        isError
    )

internal fun ShortWeatherWidgetInfo.toDTO() =
    ShortWeatherWidgetInfoDTO(
        currentTemperature,
        maxTemperature,
        minTemperature,
        weatherCode,
        isDay,
        lastUpdateDateTime,
        appLanguage,
        isError
    )