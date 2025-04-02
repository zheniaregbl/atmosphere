package ru.syndicate.atmosphere.core.presentation

expect class PlatformBatterySettings {
    fun requestBackgroundPermission()
    fun isBackgroundPermissionGranted(): Boolean
}