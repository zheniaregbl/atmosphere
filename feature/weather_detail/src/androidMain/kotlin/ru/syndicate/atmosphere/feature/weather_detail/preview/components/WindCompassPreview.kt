package ru.syndicate.atmosphere.feature.weather_detail.preview.components

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.syndicate.atmosphere.core.presentation.theme.AppTheme
import ru.syndicate.atmosphere.feature.weather_detail.presentation.components.WindCompass

@Preview(showBackground = true, backgroundColor = 0xFF1E1E1E)
@Composable
private fun WindCompassPreview() {
    AppTheme {
        WindCompass(
            modifier = Modifier.size(140.dp),
            speed = 2,
            direction = 0
        )
    }
}