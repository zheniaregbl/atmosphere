package ru.syndicate.atmosphere.widget.worker

import androidx.work.BackoffPolicy
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import java.time.Duration
import java.util.concurrent.TimeUnit

fun setupWorker(
    workManager: WorkManager,
    timing: Long = 15,
    disableBefore: Boolean = false
) {

    if (disableBefore) workManager.cancelUniqueWork("atmosphereWeatherWork")

    val workRequest = PeriodicWorkRequest.Builder(
        WeatherWorker::class.java,
        timing,
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