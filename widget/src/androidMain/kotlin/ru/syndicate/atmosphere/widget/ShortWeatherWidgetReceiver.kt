package ru.syndicate.atmosphere.widget

import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetManager
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.state.updateAppWidgetState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ru.syndicate.atmosphere.widget.data.mapper.toDTO
import ru.syndicate.atmosphere.widget.domain.repository.WeatherWidgetRepository

class ShortWeatherWidgetReceiver: GlanceAppWidgetReceiver(), KoinComponent {

    private val widgetWeatherRepository by inject<WeatherWidgetRepository>()

    override val glanceAppWidget: GlanceAppWidget
        get() = ShortWeatherWidget()

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

            val glanceIds = GlanceAppWidgetManager(context).getGlanceIds(ShortWeatherWidget::class.java)

            glanceIds.forEach { id ->

                updateAppWidgetState(context, id) { state ->
                    state[IsLoading] = true
                }
                glanceAppWidget.update(context, id)
            }

            getWeather(context)
        }
    }

    private suspend fun getWeather(context: Context) {

        val glanceIds = GlanceAppWidgetManager(context).getGlanceIds(ShortWeatherWidget::class.java)

        glanceIds.forEach { id ->

            updateAppWidgetState(context, id) { state ->

                val weatherWidgetInfo = widgetWeatherRepository.getWidgetWeather()

                state[WeatherWidgetInfo] = Json.encodeToString(weatherWidgetInfo.toDTO())
                state[IsLoading] = false
            }

            delay(500)

            glanceAppWidget.update(context, id)
        }
    }

    companion object {
        val IsLoading = booleanPreferencesKey("is_loading")
        val WeatherWidgetInfo = stringPreferencesKey("weather_widget")

        const val UPDATE_ACTION = "update_action"
    }
}