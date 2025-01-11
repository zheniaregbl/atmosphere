package ru.syndicate.atmosphere.feature.search.domain.model

data class City(
    val title: String = "Moscow",
    val country: String = "Russia",
    val flagUrl: String = "",
    val timeZone: String = "Europe/Moscow",
    val latitude: Double = 55.75222,
    val longitude: Double = 37.61556
)