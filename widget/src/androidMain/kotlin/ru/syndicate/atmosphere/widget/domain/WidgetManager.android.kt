package ru.syndicate.atmosphere.widget.domain

import android.content.Context
import android.content.Intent
import androidx.work.WorkManager
import ru.syndicate.atmosphere.widget.ShortWeatherWidgetReceiver
import ru.syndicate.atmosphere.widget.worker.setupWorker

actual class WidgetManager(private val context: Context) {

    actual fun updateWidget() {
        val intent = Intent(context, ShortWeatherWidgetReceiver::class.java).apply {
            action = ShortWeatherWidgetReceiver.UPDATE_ACTION
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