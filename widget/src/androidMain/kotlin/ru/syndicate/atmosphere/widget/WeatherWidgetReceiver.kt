package ru.syndicate.atmosphere.widget

import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetManager
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.state.updateAppWidgetState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
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

        CoroutineScope(Dispatchers.IO).launch {

            val glanceIds = GlanceAppWidgetManager(context).getGlanceIds(WeatherWidget::class.java)

            glanceIds.forEach { id ->

                updateAppWidgetState(context, id) { state ->
                    state[IsUpdating] = true
                }
                glanceAppWidget.update(context, id)
            }

            getWeather(context)
        }
    }

    private suspend fun getWeather(context: Context) {

        val glanceIds = GlanceAppWidgetManager(context).getGlanceIds(WeatherWidget::class.java)

        glanceIds.forEach { id ->

            updateAppWidgetState(context, id) { state ->

                val weatherWidgetInfo = widgetWeatherRepository.getWidgetWeather()

                state[CurrentTemperatureKey] = weatherWidgetInfo.currentTemperature
                state[MaxTemperatureKey] = weatherWidgetInfo.maxTemperature
                state[MinTemperatureKey] = weatherWidgetInfo.minTemperature
                state[CurrentWeatherCodeKey] = weatherWidgetInfo.weatherCode
                state[LastUpdateTime] = weatherWidgetInfo.lastUpdateTime.toString()
                state[AppLanguage] = weatherWidgetInfo.appLanguage
                state[IsUpdating] = false
            }

            delay(500)

            glanceAppWidget.update(context, id)
        }
    }

    companion object {
        val CurrentTemperatureKey = intPreferencesKey("current_temperature")
        val MaxTemperatureKey = intPreferencesKey("max_temperature")
        val MinTemperatureKey = intPreferencesKey("min_temperature")
        val CurrentWeatherCodeKey = intPreferencesKey("current_weather_code")
        val LastUpdateTime = stringPreferencesKey("last_update_time")
        val IsUpdating = booleanPreferencesKey("is_updating")
        val AppLanguage = stringPreferencesKey("app_language")

        const val UPDATE_ACTION = "update_action"
    }
}