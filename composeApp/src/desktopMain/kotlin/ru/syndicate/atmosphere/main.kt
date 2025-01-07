package ru.syndicate.atmosphere

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ru.syndicate.atmosphere.feature.home.di.initKoin

fun main() {
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