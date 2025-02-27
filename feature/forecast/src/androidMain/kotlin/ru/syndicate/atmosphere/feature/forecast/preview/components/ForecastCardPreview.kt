package ru.syndicate.atmosphere.feature.forecast.preview.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.syndicate.atmosphere.core.presentation.theme.AppTheme
import ru.syndicate.atmosphere.feature.forecast.domain.model.DailyForecast
import ru.syndicate.atmosphere.feature.forecast.presentation.components.ForecastCard

@Preview
@Composable
private fun ForecastCardPreview() {
    AppTheme {
        ForecastCard(
            modifier = Modifier.fillMaxWidth(),
            dailyForecast = DailyForecast()
        )
    }
}