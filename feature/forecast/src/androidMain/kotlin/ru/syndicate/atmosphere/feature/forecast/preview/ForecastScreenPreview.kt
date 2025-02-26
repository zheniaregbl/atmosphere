package ru.syndicate.atmosphere.feature.forecast.preview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.syndicate.atmosphere.core.presentation.theme.AppTheme
import ru.syndicate.atmosphere.core.presentation.theme.BackgroundColor
import ru.syndicate.atmosphere.feature.forecast.presentation.ForecastScreenImpl

@Preview
@Composable
private fun ForecastScreenPreview() {

    AppTheme {
        ForecastScreenImpl(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundColor)
                .statusBarsPadding(),
            onBackClick = { }
        )
    }
}