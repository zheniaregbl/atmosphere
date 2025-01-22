package ru.syndicate.atmosphere

import android.app.Application
import cafe.adriel.voyager.core.registry.ScreenRegistry
import org.koin.android.ext.koin.androidContext
import ru.syndicate.atmosphere.di.androidPlatformModules
import ru.syndicate.atmosphere.di.initKoin
import ru.syndicate.atmosphere.feature.search.di.featureSearchScreenModule
import ru.syndicate.atmosphere.feature.settings.di.featureSettingsScreenModule

class WeatherApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        ScreenRegistry {
            featureSearchScreenModule()
            featureSettingsScreenModule()
        }

        initKoin(
            config = { androidContext(this@WeatherApplication) },
            platformModules = androidPlatformModules(this@WeatherApplication)
        )
    }
}