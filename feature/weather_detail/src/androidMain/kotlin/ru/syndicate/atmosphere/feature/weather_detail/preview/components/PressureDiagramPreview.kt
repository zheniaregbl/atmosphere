package ru.syndicate.atmosphere.feature.weather_detail.preview.components

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.syndicate.atmosphere.core.presentation.theme.AppTheme
import ru.syndicate.atmosphere.feature.weather_detail.presentation.components.PressureDiagram

@Preview
@Composable
private fun PressureDiagramPreview() {
    AppTheme {
        PressureDiagram(modifier = Modifier.size(130.dp))
    }
}