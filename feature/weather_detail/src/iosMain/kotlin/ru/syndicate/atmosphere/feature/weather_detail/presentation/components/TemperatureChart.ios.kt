package ru.syndicate.atmosphere.feature.weather_detail.presentation.components

import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.patrykandpatrick.vico.multiplatform.cartesian.CartesianChartHost
import com.patrykandpatrick.vico.multiplatform.cartesian.axis.HorizontalAxis
import com.patrykandpatrick.vico.multiplatform.cartesian.axis.VerticalAxis
import com.patrykandpatrick.vico.multiplatform.cartesian.axis.rememberAxisGuidelineComponent
import com.patrykandpatrick.vico.multiplatform.cartesian.data.CartesianChartModelProducer
import com.patrykandpatrick.vico.multiplatform.cartesian.data.lineSeries
import com.patrykandpatrick.vico.multiplatform.cartesian.layer.LineCartesianLayer
import com.patrykandpatrick.vico.multiplatform.cartesian.layer.rememberLine
import com.patrykandpatrick.vico.multiplatform.cartesian.layer.rememberLineCartesianLayer
import com.patrykandpatrick.vico.multiplatform.cartesian.marker.rememberDefaultCartesianMarker
import com.patrykandpatrick.vico.multiplatform.cartesian.rememberCartesianChart
import com.patrykandpatrick.vico.multiplatform.common.Insets
import com.patrykandpatrick.vico.multiplatform.common.LayeredComponent
import com.patrykandpatrick.vico.multiplatform.common.ProvideVicoTheme
import com.patrykandpatrick.vico.multiplatform.common.component.ShapeComponent
import com.patrykandpatrick.vico.multiplatform.common.component.TextComponent
import com.patrykandpatrick.vico.multiplatform.common.component.rememberShapeComponent
import com.patrykandpatrick.vico.multiplatform.common.component.rememberTextComponent
import com.patrykandpatrick.vico.multiplatform.common.fill
import com.patrykandpatrick.vico.multiplatform.common.shape.CorneredShape
import com.patrykandpatrick.vico.multiplatform.common.shape.MarkerCorneredShape
import com.patrykandpatrick.vico.multiplatform.common.vicoTheme
import ru.syndicate.atmosphere.core.presentation.theme.SelectedBlue

internal const val MARKER_TICK_SIZE: Float = 6f

internal fun markerCorneredShape(
    all: CorneredShape.Corner,
    tickSize: Dp = MARKER_TICK_SIZE.dp,
): MarkerCorneredShape = MarkerCorneredShape(all, tickSize)

@Composable
internal actual fun TemperatureChart(temperatures: List<Int>) {

    val modelProducer = remember { CartesianChartModelProducer() }

    val lineColor = SelectedBlue
    val labelBackground = rememberShapeComponent(
        fill = fill(Color.White),
        shape = markerCorneredShape(CorneredShape.Corner.Rounded)
    )
    val label = rememberTextComponent(
        style = TextStyle(
            fontFamily = LocalTextStyle.current.fontFamily,
            fontWeight = FontWeight.Medium,
            color = SelectedBlue
        ),
        padding = Insets(8.dp, 4.dp),
        background = labelBackground,
        minWidth = TextComponent.MinWidth.fixed(40.dp)
    )

    val indicatorFrontComponent =
        rememberShapeComponent(
            fill = fill(Color.White),
            shape = CorneredShape.Pill
        )

    LaunchedEffect(Unit) {
        modelProducer.runTransaction {
            lineSeries {
                series(y = temperatures)
            }
        }
    }

    ProvideVicoTheme(
        theme = vicoTheme.copy(
            lineColor = Color.White.copy(alpha = .3f),
            textColor = Color.White
        )
    ) {
        CartesianChartHost(
            chart = rememberCartesianChart(
                rememberLineCartesianLayer(
                    lineProvider = LineCartesianLayer.LineProvider.series(
                        LineCartesianLayer.rememberLine(
                            fill = LineCartesianLayer.LineFill.single(fill(lineColor)),
                            areaFill = LineCartesianLayer.AreaFill.single(
                                fill(
                                    Brush.verticalGradient(
                                        listOf(lineColor.copy(alpha = .4f), Color.Transparent)
                                    )
                                )
                            )
                        )
                    )
                ),
                startAxis = VerticalAxis.rememberStart(),
                bottomAxis = HorizontalAxis.rememberBottom(),
                marker = rememberDefaultCartesianMarker(
                    label = label,
                    indicator = { color ->
                        LayeredComponent(
                            back = ShapeComponent(
                                fill = fill(color.copy(alpha = 0.4f)),
                                shape = CorneredShape.Pill
                            ),
                            front = LayeredComponent(
                                back = ShapeComponent(
                                    fill = fill(color),
                                    shape = CorneredShape.Pill
                                ),
                                front = indicatorFrontComponent,
                                padding = Insets(5.dp)
                            ),
                            padding = Insets(10.dp)
                        )
                    },
                    indicatorSize = 36.dp,
                    guideline = rememberAxisGuidelineComponent()
                )
            ),
            modelProducer = modelProducer
        )
    }
}