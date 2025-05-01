package ru.syndicate.atmosphere.feature.weather_detail.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.atmosphere.feature.weather_detail.presentation.translation.util.LocalDetailsStrings
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
internal fun PressureDiagram(
    modifier: Modifier = Modifier,
    meanPressure: Double = 993.0
) {

    val minPressure = 700.0
    val maxPressure = 1200.0
    val pressureRange = maxPressure - minPressure

    val startAngle = 135f
    val sweepAngle = 270f

    val normalizedPressure = (meanPressure - minPressure).coerceIn(0.0, pressureRange)
    val pressureAngle = startAngle + (normalizedPressure / pressureRange) * sweepAngle

    Box(modifier = modifier) {

        Canvas(modifier = Modifier.matchParentSize()) {

            val radius = size.width / 2
            val center = Offset(radius, radius)

            val numTicks = 50
            val tickAngleStep = sweepAngle / numTicks

            for (i in 0..numTicks) {

                val angle = startAngle + i * tickAngleStep
                val angleRad = degreesToRadians(angle.toDouble())
                val innerRadius = radius - 2.dp.toPx()
                val outerRadius = radius - if (i % 5 == 0) 10.dp.toPx() else 6.dp.toPx()

                val startX = center.x + innerRadius * cos(angleRad).toFloat()
                val startY = center.y + innerRadius * sin(angleRad).toFloat()
                val endX = center.x + outerRadius * cos(angleRad).toFloat()
                val endY = center.y + outerRadius * sin(angleRad).toFloat()

                drawLine(
                    color = Color.White.copy(alpha = .7f),
                    start = Offset(startX, startY),
                    end = Offset(endX, endY),
                    strokeWidth = 2.dp.toPx()
                )
            }

            val arcRadius = radius
            val arrowLength = 14.dp.toPx()

            val arrowAngleRad = degreesToRadians(pressureAngle.toDouble())
            val startX = center.x + arcRadius * cos(arrowAngleRad).toFloat()
            val startY = center.y + arcRadius * sin(arrowAngleRad).toFloat()

            val endX = center.x + (arcRadius - arrowLength) * cos(arrowAngleRad).toFloat()
            val endY = center.y + (arcRadius - arrowLength) * sin(arrowAngleRad).toFloat()

            drawLine(
                color = Color.White,
                start = Offset(startX, startY),
                end = Offset(endX, endY),
                strokeWidth = 2.dp.toPx()
            )
        }

        Canvas(
            modifier = Modifier
                .matchParentSize()
                .padding(5.dp)
        ) {
            val radius = size.width / 2
            val center = Offset(radius, radius)

            val arcStartAngle = (pressureAngle - 15.0).toFloat()
            val arcSweepAngle = 31f

            val startAngleRad = degreesToRadians(arcStartAngle.toDouble())
            val endAngleRad = degreesToRadians((arcStartAngle + arcSweepAngle).toDouble())

            val startPoint = Offset(
                center.x + radius * cos(startAngleRad).toFloat(),
                center.y + radius * sin(startAngleRad).toFloat()
            )

            val endPoint = Offset(
                center.x + radius * cos(endAngleRad).toFloat(),
                center.y + radius * sin(endAngleRad).toFloat()
            )

            val gradientBrush = Brush.linearGradient(
                colors = listOf(
                    Color.Transparent,
                    Color.White.copy(alpha = 0.65f),
                    Color.White,
                    Color.White.copy(alpha = 0.65f),
                    Color.Transparent
                ),
                start = startPoint,
                end = endPoint
            )

            drawArc(
                brush = gradientBrush,
                startAngle = arcStartAngle,
                sweepAngle = arcSweepAngle,
                useCenter = false,
                style = Stroke(8.dp.toPx())
            )
        }

        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = meanPressure.toString(),
                style = LocalTextStyle.current,
                lineHeight = 16.sp,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = Color.White
            )

            Text(
                text = LocalDetailsStrings.current.pressureUnit,
                style = LocalTextStyle.current,
                lineHeight = 12.sp,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                color = Color.White
            )
        }
    }
}

private fun degreesToRadians(degrees: Double): Double {
    return degrees * PI / 180.0
}