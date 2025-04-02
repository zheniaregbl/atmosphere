package ru.syndicate.atmosphere.widget.domain

import android.content.Context
import android.content.Intent
import androidx.work.WorkManager
import ru.syndicate.atmosphere.widget.WeatherWidgetReceiver
import ru.syndicate.atmosphere.widget.worker.setupWorker

actual class WidgetManager(private val context: Context) {

    actual fun updateWidget() {
        val intent = Intent(context, WeatherWidgetReceiver::class.java).apply {
            action = WeatherWidgetReceiver.UPDATE_ACTION
        }
        context.sendBroadcast(intent)
    }

    actual fun rerunWidget(timing: Int) {
        setupWorker(
            WorkManager.getInstance(context),
            timing.toLong(),
            true
        )
    }
}