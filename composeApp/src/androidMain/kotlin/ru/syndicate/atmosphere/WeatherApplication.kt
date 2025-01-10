package ru.syndicate.atmosphere

import android.app.Application
import cafe.adriel.voyager.core.registry.ScreenRegistry
import org.koin.android.ext.koin.androidContext
import ru.syndicate.atmosphere.feature.home.di.initKoin
import ru.syndicate.atmosphere.navigation.featureSearchModule

class WeatherApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        ScreenRegistry {
            featureSearchModule()
        }

        initKoin {
            androidContext(this@WeatherApplication)
        }
    }
}