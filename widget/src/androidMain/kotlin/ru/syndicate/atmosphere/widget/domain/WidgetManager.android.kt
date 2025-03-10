package ru.syndicate.atmosphere.widget.domain

import android.content.Context
import android.content.Intent
import ru.syndicate.atmosphere.widget.WeatherWidgetReceiver

actual class WidgetManager(private val context: Context) {
    actual fun updateWidget() {
        val intent = Intent(context, WeatherWidgetReceiver::class.java).apply {
            action = WeatherWidgetReceiver.UPDATE_ACTION
        }
        context.sendBroadcast(intent)
    }
}