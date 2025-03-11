package ru.syndicate.atmosphere.widget

import android.content.Context
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.currentState
import androidx.glance.layout.Alignment
import androidx.glance.layout.Box
import androidx.glance.layout.fillMaxSize
import kotlinx.datetime.LocalDateTime
import ru.syndicate.atmosphere.core.presentation.translation.Locales
import ru.syndicate.atmosphere.widget.presentation.WeatherWidgetErrorUI
import ru.syndicate.atmosphere.widget.presentation.WeatherWidgetUI
import ru.syndicate.atmosphere.widget.presentation.util.getWeekDayByLanguage

internal class WeatherWidget : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) = provideContent {

        val currentTemperature = currentState(WeatherWidgetReceiver.CurrentTemperatureKey) ?: 99
        val maxTemperature = currentState(WeatherWidgetReceiver.MaxTemperatureKey) ?: 99
        val minTemperature = currentState(WeatherWidgetReceiver.MinTemperatureKey) ?: 99
        val currentWeatherCode = currentState(WeatherWidgetReceiver.CurrentWeatherCodeKey) ?: 1
        val lastUpdateDateTime = currentState(WeatherWidgetReceiver.LastUpdateTime) ?: ""
        val isUpdating = currentState(WeatherWidgetReceiver.IsUpdating) ?: true
        val isError = currentState(WeatherWidgetReceiver.IsError) ?: false
        val appLanguage = currentState(WeatherWidgetReceiver.AppLanguage) ?: Locales.EN

        val lastUpdateTime = if (lastUpdateDateTime.isBlank()) "" else {
            val localDateTime = LocalDateTime.parse(lastUpdateDateTime)
            val minutes = if (localDateTime.minute < 10) "0${localDateTime.minute}"
            else localDateTime.minute.toString()
            "${localDateTime.hour}:$minutes"
        }
        val lastUpdateDay = if (lastUpdateDateTime.isBlank()) "" else {
            val localDateTime = LocalDateTime.parse(lastUpdateDateTime)
            getWeekDayByLanguage(localDateTime.dayOfWeek, appLanguage)
        }

        Box(
            modifier = GlanceModifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            if (isError) {
                WeatherWidgetErrorUI(appLanguage)
            } else {
                WeatherWidgetUI(
                    currentTemperature = currentTemperature,
                    maxTemperature = maxTemperature,
                    minTemperature = minTemperature,
                    currentWeatherCode = currentWeatherCode,
                    lastUpdateTime = lastUpdateTime,
                    lastUpdateDay = lastUpdateDay,
                    isUpdating = isUpdating,
                    appLanguage = appLanguage
                )
            }
        }
    }
}