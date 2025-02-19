package ru.syndicate.atmosphere.feature.weather_detail.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal expect fun TemperatureChart(temperatures: List<Int>)