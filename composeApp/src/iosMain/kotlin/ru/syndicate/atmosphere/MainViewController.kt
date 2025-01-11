package ru.syndicate.atmosphere

import androidx.compose.ui.window.ComposeUIViewController
import cafe.adriel.voyager.core.registry.ScreenRegistry
import ru.syndicate.atmosphere.di.initKoin
import ru.syndicate.atmosphere.di.iosPlatformModules
import ru.syndicate.atmosphere.navigation.featureSearchModule

fun MainViewController() = ComposeUIViewController(
    configure = {
        ScreenRegistry { featureSearchModule() }
        initKoin(platformModules = iosPlatformModules)
    }
) { App() }