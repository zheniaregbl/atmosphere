package ru.syndicate.atmosphere.feature.weather_detail.presentation.components

import androidx.annotation.FloatRange
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import ru.syndicate.atmosphere.core.presentation.theme.LightWhite
import ru.syndicate.atmosphere.feature.weather_detail.presentation.theme.SunColor
import ru.syndicate.atmosphere.feature.weather_detail.resources.Res
import ru.syndicate.atmosphere.feature.weather_detail.resources.moon_svg
import ru.syndicate.atmosphere.feature.weather_detail.resources.sun_svg
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
internal fun SunDiagram(
    modifier: Modifier = Modifier,
    @FloatRange(from = 0.0, to = 1.0) percentage: Float = 0f
) {

    val painter = painterResource(
        if (percentage <= 0.5f) Res.drawable.sun_svg
        else Res.drawable.moon_svg
    )

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

            withTransform(
                {
                    translate(
                        left = x - painter.intrinsicSize.width * 0.7f / 2,
                        top = y - painter.intrinsicSize.height * 0.7f / 2
                    )
                }
            ) {
                with(painter) {
                    draw(
                        size = painter.intrinsicSize * 0.7f,
                        colorFilter = ColorFilter.tint(
                            if (percentage <= 0.5f) SunColor
                            else LightWhite
                        )
                    )
                }
            }
        }
    }
}

private fun toRadians(deg: Double): Double = deg / 180.0 * PI