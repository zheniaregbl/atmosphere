package ru.syndicate.atmosphere.feature.home.preview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.syndicate.atmosphere.core.presentation.theme.AppTheme
import ru.syndicate.atmosphere.core.presentation.theme.BackgroundColor
import ru.syndicate.atmosphere.feature.home.domain.model.CurrentWeatherParameters
import ru.syndicate.atmosphere.feature.home.domain.model.HourlyWeather
import ru.syndicate.atmosphere.feature.home.domain.model.WeatherInfo
import ru.syndicate.atmosphere.feature.home.presentation.HomeScreenImpl
import ru.syndicate.atmosphere.feature.home.presentation.HomeState

internal val previewState =
    HomeState(
        weatherInfo = WeatherInfo(
            currentWeatherParameters = CurrentWeatherParameters(weatherCode = 1),
            hourlyWeather = HourlyWeather(
                temperatures = List(24) { 0.0 },
                weatherCodes = List(24) { 1 }
            )
        )
    )

internal val previewStateLoading =
    HomeState(isLoading = true)

@Preview(device = "id:desktop_small")
@Composable
private fun HomeScreenPreview() {

    val state = remember { mutableStateOf(previewState) }

    AppTheme {
        HomeScreenImpl(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundColor),
            state = state,
            currentTown = state.value.currentLocation.title,
            onAction = { },
            onSearchClick = { },
            onSettingsClick = { }
        )
    }
}

@Preview()
@Composable
private fun DesktopHomeScreenPreview() {

    val state = remember { mutableStateOf(previewState) }

    AppTheme {
        HomeScreenImpl(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundColor),
            state = state,
            currentTown = state.value.currentLocation.title,
            onAction = { },
            onSearchClick = { },
            onSettingsClick = { }
        )
    }
}

@Preview()
@Composable
private fun HomeScreenLoadingPreview() {

    val state = remember { mutableStateOf(previewStateLoading) }

    AppTheme {
        HomeScreenImpl(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundColor),
            state = state,
            currentTown = state.value.currentLocation.title,
            onAction = { },
            onSearchClick = { },
            onSettingsClick = { }
        )
    }
}

@Preview(device = "id:desktop_small")
@Composable
private fun DesktopHomeScreenLoadingPreview() {

    val state = remember { mutableStateOf(previewStateLoading) }

    AppTheme {
        HomeScreenImpl(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundColor),
            state = state,
            currentTown = state.value.currentLocation.title,
            onAction = { },
            onSearchClick = { },
            onSettingsClick = { }
        )
    }
}