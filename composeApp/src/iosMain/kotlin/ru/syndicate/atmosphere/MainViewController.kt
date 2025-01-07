package ru.syndicate.atmosphere

import androidx.compose.ui.window.ComposeUIViewController
import ru.syndicate.atmosphere.feature.home.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = { initKoin() }
) { App() }