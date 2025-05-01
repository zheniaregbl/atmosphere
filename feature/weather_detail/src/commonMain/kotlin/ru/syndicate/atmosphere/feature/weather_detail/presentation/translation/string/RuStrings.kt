package ru.syndicate.atmosphere.feature.weather_detail.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.RU)
internal val RuStrings = Strings(
    screenTitle = "Детали",
    tempSectionTitle = "Температура",
    maximum = "Максимум",
    minimum = "Минимум",
    precipitationSectionTitle = "Осадки",
    precipitationHours = "Часы с осадками",
    sumPrecipitation = "Сумма осадков",
    hourUnit = "ч",
    sumUnit = "мм",
    timePrefix = "в",
    windSectionTitle = "Ветер",
    sunSectionTitle = "Солнце",
    windUnit = "м/с",
    northSide = "Север",
    eastSide = "Восток",
    southSide = "Юг",
    westSide = "Запад",
    maximumWindSpeed = "Максимальная скорость ветра",
    maximumWindGusts = "Максимальные порывы ветра",
    windDirection = "Направление ветра",
    sunriseText = "Восход в",
    sunsetText = "Закат в",
    daylightDuration = "Продолжительность светового дня",
    pressureSectionTitle = "Давление",
    meanPressureText = "Среднее давление",
    maxPressureText = "Максимальное давление",
    minPressureText = "Минимальное давление",
    pressureUnit = "гПа",
    errorContentStrings = ErrorContentStrings(
        title = "Ошибка запроса",
        text = "Произошла ошибка при получении подробной информации о погоде.",
        repeatText = "Повторить"
    )
)