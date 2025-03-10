package ru.syndicate.atmosphere.widget.presentation.util

import kotlinx.datetime.DayOfWeek
import ru.syndicate.atmosphere.core.presentation.translation.Locales
import ru.syndicate.atmosphere.widget.presentation.translation.DeStrings
import ru.syndicate.atmosphere.widget.presentation.translation.EnStrings
import ru.syndicate.atmosphere.widget.presentation.translation.EsStrings
import ru.syndicate.atmosphere.widget.presentation.translation.FrStrings
import ru.syndicate.atmosphere.widget.presentation.translation.ItStrings
import ru.syndicate.atmosphere.widget.presentation.translation.PtStrings
import ru.syndicate.atmosphere.widget.presentation.translation.RuStrings

internal fun getWeekDayByLanguage(dayOfWeek: DayOfWeek, language: String): String {

    val strings = when (language) {
        Locales.DE -> DeStrings
        Locales.EN -> EnStrings
        Locales.ES -> EsStrings
        Locales.FR -> FrStrings
        Locales.IT -> ItStrings
        Locales.PT -> PtStrings
        Locales.RU -> RuStrings
        else -> EnStrings
    }

    return when (dayOfWeek) {
        DayOfWeek.MONDAY -> strings.weekDayTitle.monday
        DayOfWeek.TUESDAY -> strings.weekDayTitle.tuesday
        DayOfWeek.WEDNESDAY -> strings.weekDayTitle.wednesday
        DayOfWeek.THURSDAY -> strings.weekDayTitle.thursday
        DayOfWeek.FRIDAY -> strings.weekDayTitle.friday
        DayOfWeek.SATURDAY -> strings.weekDayTitle.saturday
        DayOfWeek.SUNDAY -> strings.weekDayTitle.sunday
        else -> strings.weekDayTitle.monday
    }
}