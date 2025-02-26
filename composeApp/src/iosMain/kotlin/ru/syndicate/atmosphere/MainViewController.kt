package ru.syndicate.atmosphere

import androidx.compose.ui.window.ComposeUIViewController
import cafe.adriel.voyager.core.registry.ScreenRegistry
import ru.syndicate.atmosphere.di.initKoin
import ru.syndicate.atmosphere.di.iosPlatformModules
import ru.syndicate.atmosphere.feature.forecast.di.featureForecastScreenModule
import ru.syndicate.atmosphere.feature.home.di.featureHomeScreenModule
import ru.syndicate.atmosphere.feature.search.di.featureSearchScreenModule
import ru.syndicate.atmosphere.feature.settings.di.featureSettingsScreenModule
import ru.syndicate.atmosphere.feature.weather_detail.di.featureWeatherDetailScreenModule

fun MainViewController() = ComposeUIViewController(
    configure = {

        ScreenRegistry {
            featureHomeScreenModule()
            featureSearchScreenModule()
            featureSettingsScreenModule()
            featureWeatherDetailScreenModule()
            featureForecastScreenModule()
        }

        initKoin(platformModules = iosPlatformModules)
    }
) { App() }