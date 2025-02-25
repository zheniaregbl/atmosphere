package ru.syndicate.atmosphere.feature.home.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import ru.syndicate.atmosphere.feature.home.presentation.HomeState

@Composable
internal expect fun ForecastSection(
    modifier: Modifier = Modifier,
    state: State<HomeState>
)