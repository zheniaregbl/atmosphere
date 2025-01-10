package ru.syndicate.atmosphere

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import cafe.adriel.voyager.core.registry.ScreenRegistry
import ru.syndicate.atmosphere.feature.home.di.initKoin
import ru.syndicate.atmosphere.navigation.featureSearchModule

fun main() {
    ScreenRegistry { featureSearchModule() }
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Atmosphere",
        ) {
            App()
        }
    }
}