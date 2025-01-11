package ru.syndicate.atmosphere

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import cafe.adriel.voyager.core.registry.ScreenRegistry
import ru.syndicate.atmosphere.di.desktopPlatformModules
import ru.syndicate.atmosphere.di.initKoin
import ru.syndicate.atmosphere.navigation.featureSearchModule

fun main() {
    ScreenRegistry { featureSearchModule() }
    initKoin(platformModules = desktopPlatformModules)
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Atmosphere",
        ) {
            App()
        }
    }
}