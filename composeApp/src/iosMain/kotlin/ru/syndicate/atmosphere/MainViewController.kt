package ru.syndicate.atmosphere

import androidx.compose.ui.window.ComposeUIViewController
import cafe.adriel.voyager.core.registry.ScreenRegistry
import ru.syndicate.atmosphere.di.initKoin
import ru.syndicate.atmosphere.di.iosPlatformModules
import ru.syndicate.atmosphere.feature.home.di.featureHomeScreenModule
import ru.syndicate.atmosphere.feature.search.di.featureSearchScreenModule
import ru.syndicate.atmosphere.feature.settings.di.featureSettingsScreenModule

fun MainViewController() = ComposeUIViewController(
    configure = {

        ScreenRegistry {
            featureHomeScreenModule()
            featureSearchScreenModule()
            featureSettingsScreenModule()
        }

        initKoin(platformModules = iosPlatformModules)
    }
) { App() }