package ru.syndicate.atmosphere.feature.weather_detail.preview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.syndicate.atmosphere.core.presentation.theme.AppTheme
import ru.syndicate.atmosphere.core.presentation.theme.BackgroundColor
import ru.syndicate.atmosphere.feature.weather_detail.presentation.WeatherDetailScreenImpl

@Preview
@Composable
private fun WeatherDetailScreenPreview() {

    AppTheme {
        WeatherDetailScreenImpl(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundColor),
            onBackClick = { }
        )
    }
}

@Preview(device = "id:desktop_small")
@Composable
private fun DesktopWeatherDetailScreenPreview() {

    AppTheme {
        WeatherDetailScreenImpl(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundColor),
            onBackClick = {}
        )
    }
}