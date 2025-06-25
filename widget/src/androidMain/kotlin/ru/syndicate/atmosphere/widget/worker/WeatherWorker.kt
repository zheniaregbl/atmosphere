package ru.syndicate.atmosphere.widget.worker

import android.content.Context
import android.content.Intent
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import ru.syndicate.atmosphere.widget.ShortWeatherWidgetReceiver

internal class WeatherWorker(
    private val context: Context,
    workerParameters: WorkerParameters
) : CoroutineWorker(context, workerParameters) {
    override suspend fun doWork(): Result {

        val intent = Intent(context, ShortWeatherWidgetReceiver::class.java).apply {
            action = ShortWeatherWidgetReceiver.UPDATE_ACTION
        }
        applicationContext.sendBroadcast(intent)

        return Result.success()
    }
}