package ru.syndicate.atmosphere.widget.worker

import androidx.work.BackoffPolicy
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import java.time.Duration
import java.util.concurrent.TimeUnit

fun setupWorker(workManager: WorkManager) {

    val workRequest = PeriodicWorkRequest.Builder(
        WeatherWorker::class.java,
        15,
        TimeUnit.MINUTES
    ).setBackoffCriteria(
        BackoffPolicy.LINEAR,
        Duration.ofSeconds(10)
    ).build()

    workManager.enqueueUniquePeriodicWork(
        "atmosphereWeatherWork",
        ExistingPeriodicWorkPolicy.KEEP,
        workRequest
    )
}