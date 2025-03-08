package ru.syndicate.atmosphere.widget

import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetManager
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.state.updateAppWidgetState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ru.syndicate.atmosphere.widget.domain.repository.WidgetWeatherRepository

class WeatherWidgetReceiver: GlanceAppWidgetReceiver(), KoinComponent {

    private val widgetWeatherRepository by inject<WidgetWeatherRepository>()

    override val glanceAppWidget: GlanceAppWidget
        get() = WeatherWidget()

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)
        CoroutineScope(Dispatchers.IO).launch { getWeather(context) }
    }

    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)
        CoroutineScope(Dispatchers.IO).launch { getWeather(context) }
    }

    private suspend fun getWeather(context: Context) {

        val glanceIds = GlanceAppWidgetManager(context).getGlanceIds(WeatherWidget::class.java)

        glanceIds.forEach { id ->

            updateAppWidgetState(context, id) { state ->
                state[CurrentTemperatureKey] = widgetWeatherRepository
                    .getWidgetWeather()
                    .currentTemperature
            }

            glanceAppWidget.update(context, id)
        }
    }

    companion object {
        val CurrentTemperatureKey = intPreferencesKey("current_temperature")
        const val UPDATE_ACTION = "update_action"
    }
}