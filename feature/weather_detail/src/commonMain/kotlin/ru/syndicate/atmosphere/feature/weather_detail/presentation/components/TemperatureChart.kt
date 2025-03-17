package ru.syndicate.atmosphere.feature.weather_detail.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.koalaplot.core.xygraph.Point
import ru.syndicate.atmosphere.core.presentation.theme.SelectedBlue
import ru.syndicate.atmosphere.feature.weather_detail.presentation.translation.util.LocalDetailsStrings

@Composable
internal fun TemperatureChart(
    modifier: Modifier,
    temperatures: List<Int>
) {

    CommonChart(
        modifier = modifier,
        values = temperatures,
        yRange = temperatures.min() - 1..temperatures.max(),
        yAxisLabels = { "$it°" },
        xViewRange = 0.0..10.0,
        yViewRange = temperatures.min().toDouble()..temperatures.max().toDouble(),
        color = SelectedBlue,
        hoverableItem = { HoverableItem(it) }
    )
}

@Composable
private fun HoverableItem(point: Point<Int, Int>) {

    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(4.dp))
            .background(Color.White.copy(alpha = 0.9f))
            .padding(horizontal = 8.dp)
            .padding(bottom = 2.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "${point.y}°",
            style = LocalTextStyle.current,
            fontWeight = FontWeight.Medium,
            lineHeight = 20.sp,
            fontSize = 14.sp
        )

        Text(
            text = "${LocalDetailsStrings.current.timePrefix} ${point.x}:00",
            style = LocalTextStyle.current,
            fontWeight = FontWeight.Normal,
            lineHeight = 20.sp,
            fontSize = 12.sp
        )
    }
}