package ru.syndicate.atmosphere.feature.weather_detail.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import io.github.koalaplot.core.line.AreaBaseline
import io.github.koalaplot.core.line.AreaPlot
import io.github.koalaplot.core.style.AreaStyle
import io.github.koalaplot.core.style.LineStyle
import io.github.koalaplot.core.util.ExperimentalKoalaPlotApi
import io.github.koalaplot.core.xygraph.DefaultPoint
import io.github.koalaplot.core.xygraph.Point
import io.github.koalaplot.core.xygraph.XYGraph
import io.github.koalaplot.core.xygraph.rememberIntLinearAxisModel
import ru.syndicate.atmosphere.core.util.PlatformName
import ru.syndicate.atmosphere.core.util.platformName

@OptIn(ExperimentalKoalaPlotApi::class)
@Composable
internal fun CommonChart(
    modifier: Modifier = Modifier,
    values: List<Int>,
    xRange: IntRange = values.indices,
    yRange: IntRange = values.min()..values.max() + 1,
    yAxisLabels: (Int) -> String = { it.toString() },
    xViewRange: ClosedRange<Double> = 0.0..100.0,
    yViewRange: ClosedRange<Double> = 0.0..100.0,
    color: Color,
    hoverableItem: @Composable (Point<Int, Int>) -> Unit
) {

    val platformName by remember { mutableStateOf(platformName()) }

    val data = buildList {
        values.forEachIndexed { index, value ->
            add(DefaultPoint(index, value))
        }
    }

    val xAxisModel = if (platformName != PlatformName.DESKTOP) {
        rememberIntLinearAxisModel(
            range = xRange,
            allowPanning = true
        ).apply { setViewRange(xViewRange) }
    } else {
        rememberIntLinearAxisModel(xRange)
    }
    val yAxisModel = if (platformName != PlatformName.DESKTOP) {
        rememberIntLinearAxisModel(
            range = yRange,
            allowPanning = true,
        ).apply { setViewRange(yViewRange) }
    } else {
        rememberIntLinearAxisModel(yRange)
    }

    MaterialTheme(
        colorScheme = MaterialTheme.colorScheme.copy(
            onBackground = Color.White
        )
    ) {
        XYGraph(
            modifier = modifier,
            xAxisModel = xAxisModel,
            yAxisModel = yAxisModel,
            yAxisLabels = { yAxisLabels(it) },
            panEnabled = platformName != PlatformName.DESKTOP,
            zoomEnabled = platformName != PlatformName.DESKTOP
        ) {
            AreaPlot(
                data = data,
                lineStyle = LineStyle(brush = SolidColor(color), strokeWidth = 2.dp),
                areaStyle = AreaStyle(
                    brush = Brush
                        .verticalGradient(
                            listOf(color, color.copy(alpha = 0.1f)),
                        ),
                    alpha = 0.5f,
                ),
                symbol = {
                    DotSymbol(
                        modifier = Modifier.hoverableElement { hoverableItem(it) },
                        color = color
                    )
                },
                areaBaseline = AreaBaseline.ConstantLine(yRange.first)
            )
        }
    }
}

@Composable
private fun DotSymbol(modifier: Modifier, color: Color) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(color)
            .padding(4.dp)
    )
}