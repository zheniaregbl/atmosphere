package ru.syndicate.atmosphere.feature.search.domain

data class City(
    val title: String = "Moscow",
    val country: String = "Russia",
    val countryCode: String = "RU",
    val timeZone: String = "Europe/Moscow",
    val latitude: Double = 55.75222,
    val longitude: Double = 37.61556
)