package ru.syndicate.atmosphere.feature.weather_detail.presentation.components

import androidx.annotation.FloatRange
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import ru.syndicate.atmosphere.core.presentation.theme.LightWhite
import kotlin.math.*

@Composable
internal fun SunDiagram(
    modifier: Modifier = Modifier,
    @FloatRange(from = 0.0, to = 1.0) percentage: Float = 0f
) {

    Box(modifier = modifier.padding(2.dp)) {

        Canvas(modifier = Modifier.matchParentSize()) {
            drawLine(
                color = Color.White,
                start = Offset(0f, size.height / 2),
                end = Offset(size.width, size.height / 2),
                strokeWidth = 1.dp.toPx()
            )
        }

        Canvas(
            modifier = Modifier
                .matchParentSize()
                .padding(5.dp)
        ) {

            drawCircle(
                color = LightWhite.copy(alpha = .3f),
                style = Stroke(1.dp.toPx())
            )

            val angleInDegrees = percentage * 360.0 + 90f
            val radius = (size.height / 2)
            val x = -(radius * sin(toRadians(angleInDegrees))).toFloat() + (size.width / 2)
            val y = (radius * cos(toRadians(angleInDegrees))).toFloat() + (size.height / 2)

            drawCircle(
                color = Color(0xFFFFB730),
                radius = 15f,
                center = Offset(x,  y)
            )
        }
    }
}

private fun toRadians(deg: Double): Double = deg / 180.0 * PI