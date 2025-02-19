package ru.syndicate.atmosphere.feature.weather_detail.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import dev.chrisbanes.haze.HazeState
import org.jetbrains.compose.resources.painterResource
import ru.syndicate.atmosphere.core.util.PlatformName
import ru.syndicate.atmosphere.core.util.platformName
import ru.syndicate.atmosphere.feature.weather_detail.presentation.components.DiagramSectionDesktop
import ru.syndicate.atmosphere.feature.weather_detail.presentation.components.DiagramSectionMobile
import ru.syndicate.atmosphere.feature.weather_detail.presentation.components.ParameterCard
import ru.syndicate.atmosphere.feature.weather_detail.presentation.components.ParameterRow
import ru.syndicate.atmosphere.feature.weather_detail.presentation.components.SunDiagram
import ru.syndicate.atmosphere.feature.weather_detail.presentation.components.TopPanel
import ru.syndicate.atmosphere.feature.weather_detail.presentation.components.WindCompass
import ru.syndicate.atmosphere.feature.weather_detail.resources.Res
import ru.syndicate.atmosphere.feature.weather_detail.resources.precipitation_svg
import ru.syndicate.atmosphere.feature.weather_detail.resources.sun_svg
import ru.syndicate.atmosphere.feature.weather_detail.resources.temperature_svg
import ru.syndicate.atmosphere.feature.weather_detail.resources.wind_svg

internal class WeatherDetailScreen : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        WeatherDetailScreenImpl(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding(),
            platformName = platformName(),
            onBackClick = { navigator.pop() }
        )
    }
}

@Composable
internal fun WeatherDetailScreenImpl(
    modifier: Modifier = Modifier,
    platformName: String,
    onBackClick: () -> Unit
) {

    val hazeState = remember { HazeState() }

    Box(modifier = modifier) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp)
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            TopPanel(
                modifier = Modifier
                    .widthIn(max = 800.dp)
                    .fillMaxWidth(),
                topPanelTitle = "Details",
                onBackClick = onBackClick
            )

            LazyColumn(
                modifier = Modifier
                    .widthIn(max = 800.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                item {
                    ParameterCard(
                        modifier = Modifier.fillMaxWidth(),
                        hazeState = hazeState,
                        title = {
                            Image(
                                painter = painterResource(Res.drawable.temperature_svg),
                                contentDescription = null
                            )
                            Text(
                                text = "Temperature",
                                style = LocalTextStyle.current,
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                color = Color.White
                            )
                        },
                        content = {

                            ParameterRow(
                                parameter = "Maximum",
                                value = buildAnnotatedString {
                                    withStyle(SpanStyle(color = Color.White)) {
                                        append("30° ")
                                    }
                                    withStyle(SpanStyle(color = Color.White.copy(alpha = .4f))) {
                                        append("(33°)")
                                    }
                                },
                                valueTextStyle = TextStyle(
                                    fontFamily = LocalTextStyle.current.fontFamily,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 14.sp
                                )
                            )

                            ParameterRow(
                                parameter = "Minimum",
                                value = buildAnnotatedString {
                                    withStyle(SpanStyle(color = Color.White)) {
                                        append("12° ")
                                    }
                                    withStyle(SpanStyle(color = Color.White.copy(alpha = .4f))) {
                                        append("(10°)")
                                    }
                                },
                                valueTextStyle = TextStyle(
                                    fontFamily = LocalTextStyle.current.fontFamily,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 14.sp
                                )
                            )
                        }
                    )
                }

                item {
                    ParameterCard(
                        modifier = Modifier.fillMaxWidth(),
                        hazeState = hazeState,
                        title = {
                            Image(
                                modifier = Modifier.size(20.dp),
                                painter = painterResource(Res.drawable.precipitation_svg),
                                contentDescription = null
                            )
                            Text(
                                text = "Precipitation",
                                style = LocalTextStyle.current,
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                color = Color.White
                            )
                        },
                        content = {
                            ParameterRow(
                                parameter = "Precipitation probability",
                                value = "45 %"
                            )
                            ParameterRow(
                                parameter = "Precipitation hours",
                                value = "2 h"
                            )
                            ParameterRow(
                                parameter = "Sum precipitation",
                                value = "100 mm"
                            )
                        }
                    )
                }

                item {
                    if (platformName == PlatformName.ANDROID || platformName == PlatformName.IOS) {
                        DiagramSectionMobile(
                            modifier = Modifier.fillMaxWidth(),
                            hazeState = hazeState
                        )
                    } else {
                        DiagramSectionDesktop(
                            modifier = Modifier.fillMaxWidth(),
                            hazeState = hazeState
                        )
                    }
                }

                item {
                    Spacer(
                        modifier = Modifier
                            .height(50.dp)
                            .padding(
                                bottom = WindowInsets
                                    .navigationBars
                                    .asPaddingValues()
                                    .calculateBottomPadding()
                            )
                    )
                }
            }
        }
    }
}