package ru.syndicate.atmosphere.feature.forecast.presentation.util

import androidx.compose.runtime.Composable
import kotlinx.datetime.DayOfWeek
import ru.syndicate.atmosphere.feature.forecast.presentation.translation.util.LocalForecastStrings

@Composable
fun DayOfWeek.localize(): String {

    val weekDays = LocalForecastStrings.current.weekDayTitle

    return when (this) {
        DayOfWeek.MONDAY -> weekDays.monday
        DayOfWeek.TUESDAY -> weekDays.tuesday
        DayOfWeek.WEDNESDAY -> weekDays.wednesday
        DayOfWeek.THURSDAY -> weekDays.thursday
        DayOfWeek.FRIDAY -> weekDays.friday
        DayOfWeek.SATURDAY -> weekDays.saturday
        DayOfWeek.SUNDAY -> weekDays.sunday
        else -> weekDays.monday
    }
}