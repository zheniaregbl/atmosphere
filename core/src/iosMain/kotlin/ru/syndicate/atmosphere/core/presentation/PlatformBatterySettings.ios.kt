package ru.syndicate.atmosphere.core.presentation

actual class PlatformBatterySettings() {
    actual fun requestBackgroundPermission() {}
    actual fun isBackgroundPermissionGranted(): Boolean {
        return true
    }
}