package ru.syndicate.atmosphere.core.presentation

actual class PlatformBatterySettings actual constructor() {
    actual fun requestBackgroundPermission() {}
    actual fun isBackgroundPermissionGranted(): Boolean {
        return true
    }
}