package ru.syndicate.atmosphere.feature.weather_detail.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.koalaplot.core.line.AreaBaseline
import io.github.koalaplot.core.line.AreaPlot
import io.github.koalaplot.core.style.AreaStyle
import io.github.koalaplot.core.style.LineStyle
import io.github.koalaplot.core.util.ExperimentalKoalaPlotApi
import io.github.koalaplot.core.xygraph.DefaultPoint
import io.github.koalaplot.core.xygraph.Point
import io.github.koalaplot.core.xygraph.XYGraph
import io.github.koalaplot.core.xygraph.rememberIntLinearAxisModel
import ru.syndicate.atmosphere.core.presentation.theme.SelectedBlue
import ru.syndicate.atmosphere.feature.weather_detail.presentation.translation.util.LocalDetailsStrings

@OptIn(ExperimentalKoalaPlotApi::class)
@Composable
internal actual fun TemperatureChart(temperatures: List<Int>) {

    val data = buildList {
        temperatures.forEachIndexed { index, temperature ->
            add(DefaultPoint(index, temperature))
        }
    }

    MaterialTheme(
        colorScheme = MaterialTheme.colorScheme.copy(
            onBackground = Color.White
        )
    ) {
        XYGraph(
            modifier = Modifier.heightIn(max = 300.dp),
            xAxisModel = rememberIntLinearAxisModel(temperatures.indices),
            yAxisModel = rememberIntLinearAxisModel(
                temperatures.min()..temperatures.max()
            ),
            yAxisLabels = { "$it" },
            panEnabled = true
        ) {

            AreaPlot(
                data = data,
                lineStyle = LineStyle(brush = SolidColor(SelectedBlue), strokeWidth = 2.dp),
                areaStyle = AreaStyle(
                    brush = Brush
                        .verticalGradient(
                            listOf(SelectedBlue, SelectedBlue.copy(alpha = 0.1f))
                        ),
                    alpha = 0.5f,
                ),
                symbol = { DotSymbol(Modifier.hoverableElement { HoverableItem(point = it) }) },
                areaBaseline = AreaBaseline.ConstantLine(0)
            )
        }
    }
}

@Composable
private fun DotSymbol(modifier: Modifier) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(SelectedBlue)
            .padding(4.dp)
    )
}

@Composable
private fun HoverableItem(point: Point<Int, Int>) {

    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(4.dp))
            .background(Color.White.copy(alpha = 0.85f))
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