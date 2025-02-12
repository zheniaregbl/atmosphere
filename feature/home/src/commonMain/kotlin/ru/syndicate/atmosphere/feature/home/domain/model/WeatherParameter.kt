package ru.syndicate.atmosphere.feature.home.domain.model

import org.jetbrains.compose.resources.DrawableResource

internal data class WeatherParameter(
    val title: String,
    val unit: String,
    val icon: DrawableResource
)