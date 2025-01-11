package ru.syndicate.atmosphere

import android.app.Application
import cafe.adriel.voyager.core.registry.ScreenRegistry
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.koinApplication
import ru.syndicate.atmosphere.di.androidPlatformModules
import ru.syndicate.atmosphere.di.initKoin
import ru.syndicate.atmosphere.navigation.featureSearchModule

class WeatherApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        ScreenRegistry {
            featureSearchModule()
        }

        initKoin(
            config = { androidContext(this@WeatherApplication) },
            platformModules = androidPlatformModules(this@WeatherApplication)
        )
    }
}