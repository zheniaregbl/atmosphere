package ru.syndicate.atmosphere

import android.app.Application
import org.koin.android.ext.koin.androidContext
import ru.syndicate.atmosphere.feature.home.di.initKoin

class WeatherApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@WeatherApplication)
        }
    }
}