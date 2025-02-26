package ru.syndicate.atmosphere.feature.forecast.presentation.util

import androidx.compose.runtime.Composable
import kotlinx.datetime.Month
import ru.syndicate.atmosphere.feature.forecast.presentation.translation.util.LocalForecastStrings

@Composable
fun Month.localize(): String {

    val months = LocalForecastStrings.current.monthTitle

    return when (this) {
        Month.JANUARY -> months.january
        Month.FEBRUARY -> months.february
        Month.MARCH -> months.march
        Month.APRIL -> months.april
        Month.MAY -> months.may
        Month.JUNE -> months.june
        Month.JULY -> months.july
        Month.AUGUST -> months.august
        Month.SEPTEMBER -> months.september
        Month.OCTOBER -> months.october
        Month.NOVEMBER -> months.november
        Month.DECEMBER -> months.december
        else -> months.january
    }
}