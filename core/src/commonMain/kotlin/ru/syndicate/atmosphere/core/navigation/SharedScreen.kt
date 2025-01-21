package ru.syndicate.atmosphere.core.navigation

import cafe.adriel.voyager.core.registry.ScreenProvider

sealed class SharedScreen : ScreenProvider {
    data object SearchScreen : SharedScreen()
}