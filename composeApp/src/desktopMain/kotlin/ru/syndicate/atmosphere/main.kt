package ru.syndicate.atmosphere

import androidx.compose.ui.Alignment
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import cafe.adriel.voyager.core.registry.ScreenRegistry
import org.jetbrains.compose.reload.DevelopmentEntryPoint
import org.jetbrains.compose.resources.painterResource
import ru.syndicate.atmosphere.composeApp.resources.Res
import ru.syndicate.atmosphere.composeApp.resources.app_icon_win_svg
import ru.syndicate.atmosphere.di.desktopPlatformModules
import ru.syndicate.atmosphere.di.initKoin
import ru.syndicate.atmosphere.feature.forecast.di.featureForecastScreenModule
import ru.syndicate.atmosphere.feature.home.di.featureHomeScreenModule
import ru.syndicate.atmosphere.feature.search.di.featureSearchScreenModule
import ru.syndicate.atmosphere.feature.settings.di.featureSettingsScreenModule
import ru.syndicate.atmosphere.feature.weather_detail.di.featureWeatherDetailScreenModule

fun main() {

    ScreenRegistry {
        featureHomeScreenModule()
        featureSearchScreenModule()
        featureSettingsScreenModule()
        featureWeatherDetailScreenModule()
        featureForecastScreenModule()
    }

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
            DevelopmentEntryPoint { App() }
        }
    }
}