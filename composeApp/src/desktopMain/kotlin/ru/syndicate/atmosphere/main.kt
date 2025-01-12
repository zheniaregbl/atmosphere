package ru.syndicate.atmosphere

import androidx.compose.ui.Alignment
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import cafe.adriel.voyager.core.registry.ScreenRegistry
import org.jetbrains.compose.resources.painterResource
import ru.syndicate.atmosphere.composeApp.resources.Res
import ru.syndicate.atmosphere.composeApp.resources.app_icon_win_svg
import ru.syndicate.atmosphere.di.desktopPlatformModules
import ru.syndicate.atmosphere.di.initKoin
import ru.syndicate.atmosphere.navigation.featureSearchModule

fun main() {

    ScreenRegistry { featureSearchModule() }
    initKoin(platformModules = desktopPlatformModules)

    application {

        val windowState = rememberWindowState(
            position = WindowPosition.Aligned(Alignment.Center)
        )

        Window(
            state = windowState,
            onCloseRequest = ::exitApplication,
            title = "Atmosphere",
            icon = painterResource(Res.drawable.app_icon_win_svg)
        ) {
            App()
        }
    }
}