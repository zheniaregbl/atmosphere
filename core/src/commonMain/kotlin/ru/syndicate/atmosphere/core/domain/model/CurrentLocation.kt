package ru.syndicate.atmosphere.core.domain.model

data class CurrentLocation(
    val title: String = "Moscow",
    val timeZone: String = "Europe/Moscow",
    val latitude: Double = 55.75222,
    val longitude: Double = 37.61556
)