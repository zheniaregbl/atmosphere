package ru.syndicate.atmosphere.feature.weather_detail.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import ru.syndicate.atmosphere.feature.weather_detail.domain.model.WeatherDetail
import ru.syndicate.atmosphere.feature.weather_detail.presentation.translation.util.LocalDetailsStrings
import ru.syndicate.atmosphere.feature.weather_detail.resources.Res
import ru.syndicate.atmosphere.feature.weather_detail.resources.sun_svg
import ru.syndicate.atmosphere.feature.weather_detail.resources.wind_svg

@Composable
internal fun DiagramSectionMobile(
    modifier: Modifier = Modifier,
    weatherDetail: WeatherDetail,
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
                    text = LocalDetailsStrings.current.windSectionTitle,
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
                    WindCompass(
                        modifier = Modifier.size(130.dp),
                        speed = weatherDetail.windInfo.maxSpeed,
                        direction = weatherDetail.windInfo.direction
                    )
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
                    text = LocalDetailsStrings.current.sunSectionTitle,
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
    weatherDetail: WeatherDetail,
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
                    text = LocalDetailsStrings.current.windSectionTitle,
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

                    WindCompass(
                        modifier = Modifier.size(130.dp),
                        speed = weatherDetail.windInfo.maxSpeed,
                        direction = weatherDetail.windInfo.direction
                    )

                    Spacer(modifier = Modifier.width(50.dp))

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {

                        ParameterRow(
                            parameter = LocalDetailsStrings.current.maximumWindSpeed,
                            value = "${weatherDetail.windInfo.maxSpeed}" +
                                    " ${LocalDetailsStrings.current.windUnit}"
                        )

                        ParameterRow(
                            parameter = LocalDetailsStrings.current.maximumWindGusts,
                            value = "? ${LocalDetailsStrings.current.windUnit}"
                        )

                        ParameterRow(
                            parameter = LocalDetailsStrings.current.windDirection,
                            value = buildAnnotatedString {

                                val direction = LocalDetailsStrings.current.northSide

                                withStyle(SpanStyle(color = Color.White)) {
                                    append("$direction ")
                                }
                                withStyle(SpanStyle(color = Color.White.copy(alpha = .4f))) {
                                    append("(${weatherDetail.windInfo.direction}°)")
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
                    text = LocalDetailsStrings.current.sunSectionTitle,
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
                            parameter = LocalDetailsStrings.current.sunriseText,
                            value = "6:23"
                        )

                        ParameterRow(
                            parameter = LocalDetailsStrings.current.sunsetText,
                            value = "23:23"
                        )

                        ParameterRow(
                            parameter = LocalDetailsStrings.current.daylightDuration,
                            value = "17 ${LocalDetailsStrings.current.hourUnit}"
                        )
                    }
                }
            }
        )
    }
}