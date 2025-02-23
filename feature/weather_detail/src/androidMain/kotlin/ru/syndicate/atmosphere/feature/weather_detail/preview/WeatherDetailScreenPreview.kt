package ru.syndicate.atmosphere.feature.weather_detail.preview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.syndicate.atmosphere.core.presentation.theme.AppTheme
import ru.syndicate.atmosphere.core.presentation.theme.BackgroundColor
import ru.syndicate.atmosphere.core.util.PlatformName
import ru.syndicate.atmosphere.feature.weather_detail.presentation.WeatherDetailScreenImpl
import ru.syndicate.atmosphere.feature.weather_detail.presentation.WeatherDetailState

internal val previewState = WeatherDetailState()

@Preview
@Composable
private fun WeatherDetailScreenPreview() {

    val state = remember { mutableStateOf(previewState) }

    AppTheme {
        WeatherDetailScreenImpl(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundColor),
            state = state,
            onBackClick = { }
        )
    }
}

@Preview(device = "id:desktop_small")
@Composable
private fun DesktopWeatherDetailScreenPreview() {

    val state = remember { mutableStateOf(previewState) }

    AppTheme {
        WeatherDetailScreenImpl(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundColor),
            state = state,
            onBackClick = {}
        )
    }
}