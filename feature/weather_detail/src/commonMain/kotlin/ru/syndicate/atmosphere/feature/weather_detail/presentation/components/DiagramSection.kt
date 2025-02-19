package ru.syndicate.atmosphere.feature.weather_detail.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import dev.chrisbanes.haze.HazeState
import org.jetbrains.compose.resources.painterResource
import ru.syndicate.atmosphere.feature.weather_detail.resources.Res
import ru.syndicate.atmosphere.feature.weather_detail.resources.sun_svg
import ru.syndicate.atmosphere.feature.weather_detail.resources.wind_svg

@Composable
internal fun DiagramSectionMobile(
    modifier: Modifier = Modifier,
    hazeState: HazeState,
) {

    Row(modifier = modifier) {

        ParameterCard(
            modifier = Modifier.weight(1f),
            hazeState = hazeState,
            title = {
                Image(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(Res.drawable.wind_svg),
                    contentDescription = null
                )
                Text(
                    text = "Wind",
                    style = LocalTextStyle.current,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = Color.White
                )
            },
            content = {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    WindCompass(modifier = Modifier.size(130.dp))
                }
            }
        )

        Spacer(modifier = Modifier.width(10.dp))

        ParameterCard(
            modifier = Modifier.weight(1f),
            hazeState = hazeState,
            title = {
                Image(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(Res.drawable.sun_svg),
                    contentDescription = null
                )
                Text(
                    text = "Sun",
                    style = LocalTextStyle.current,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = Color.White
                )
            },
            content = {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    SunDiagram(modifier = Modifier.size(130.dp))
                }
            }
        )
    }
}

@Composable
internal fun DiagramSectionDesktop(
    modifier: Modifier = Modifier,
    hazeState: HazeState,
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        ParameterCard(
            modifier = Modifier.fillMaxWidth(),
            hazeState = hazeState,
            title = {
                Image(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(Res.drawable.wind_svg),
                    contentDescription = null
                )
                Text(
                    text = "Wind",
                    style = LocalTextStyle.current,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = Color.White
                )
            },
            content = {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    WindCompass(modifier = Modifier.size(130.dp))

                    Spacer(modifier = Modifier.width(50.dp))

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {

                        ParameterRow(
                            parameter = "Maximum wind speed",
                            value = "2 m/s"
                        )

                        ParameterRow(
                            parameter = "Maximum wind gusts",
                            value = "2 m/s"
                        )

                        ParameterRow(
                            parameter = "Wind direction",
                            value = buildAnnotatedString {
                                withStyle(SpanStyle(color = Color.White)) {
                                    append("North ")
                                }
                                withStyle(SpanStyle(color = Color.White.copy(alpha = .4f))) {
                                    append("(0°)")
                                }
                            },
                            valueTextStyle = TextStyle(
                                fontFamily = LocalTextStyle.current.fontFamily,
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp
                            )
                        )
                    }
                }
            }
        )

        ParameterCard(
            modifier = Modifier.fillMaxWidth(),
            hazeState = hazeState,
            title = {
                Image(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(Res.drawable.sun_svg),
                    contentDescription = null
                )
                Text(
                    text = "Sun",
                    style = LocalTextStyle.current,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = Color.White
                )
            },
            content = {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    SunDiagram(modifier = Modifier.size(130.dp))

                    Spacer(modifier = Modifier.width(50.dp))

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {

                        ParameterRow(
                            parameter = "Sunrise at",
                            value = "6:23"
                        )

                        ParameterRow(
                            parameter = "Sunset at",
                            value = "23:23"
                        )

                        ParameterRow(
                            parameter = "Daylight duration",
                            value = "17 h"
                        )
                    }
                }
            }
        )
    }
}