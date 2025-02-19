package ru.syndicate.atmosphere.core.util

object PlatformName {
    const val ANDROID = "Android"
    const val IOS = "iOS"
    const val DESKTOP = "Desktop"
}

expect fun platformName(): String