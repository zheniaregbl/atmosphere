package ru.syndicate.atmosphere.widget

import android.content.Context
import androidx.glance.GlanceId
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.currentState
import androidx.glance.state.GlanceStateDefinition
import androidx.glance.state.PreferencesGlanceStateDefinition
import ru.syndicate.atmosphere.widget.presentation.WeatherWidgetUI

class WeatherWidget : GlanceAppWidget() {

    override val stateDefinition: GlanceStateDefinition<*> = PreferencesGlanceStateDefinition

    override suspend fun provideGlance(context: Context, id: GlanceId) = provideContent {

        val currentTemperature = currentState(WeatherWidgetReceiver.CurrentTemperatureKey) ?: 99

        WeatherWidgetUI(currentTemperature)
    }
}