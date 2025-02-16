package ru.syndicate.atmosphere.feature.weather_detail.preview.components

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.syndicate.atmosphere.feature.weather_detail.presentation.components.SunDiagram

@Preview
@Composable
private fun SunDiagramPreview() {
    SunDiagram(
        modifier = Modifier.size(140.dp),
        percentage = 1f
    )
}