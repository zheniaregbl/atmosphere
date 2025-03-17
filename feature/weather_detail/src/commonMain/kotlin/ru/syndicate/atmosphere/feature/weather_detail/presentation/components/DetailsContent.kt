package ru.syndicate.atmosphere.feature.weather_detail.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import ru.syndicate.atmosphere.core.util.PlatformName
import ru.syndicate.atmosphere.core.util.platformName
import ru.syndicate.atmosphere.feature.weather_detail.domain.model.WeatherDetail
import ru.syndicate.atmosphere.feature.weather_detail.presentation.translation.util.LocalDetailsStrings
import ru.syndicate.atmosphere.feature.weather_detail.resources.Res
import ru.syndicate.atmosphere.feature.weather_detail.resources.precipitation_svg
import ru.syndicate.atmosphere.feature.weather_detail.resources.temperature_svg

@Composable
internal fun DetailsContent(
    modifier: Modifier = Modifier,
    weatherDetail: WeatherDetail
) {

    val platformName = platformName()

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        item {
            ParameterCard(
                modifier = Modifier.fillMaxWidth(),
                title = {
                    Image(
                        painter = painterResource(Res.drawable.temperature_svg),
                        contentDescription = null
                    )
                    Text(
                        text = LocalDetailsStrings.current.tempSectionTitle,
                        style = LocalTextStyle.current,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = Color.White
                    )
                },
                content = {

                    TemperatureChart(
                        modifier = Modifier.heightIn(max = 200.dp),
                        temperatures = weatherDetail.temperatureInfo.temperatures
                    )

                    ParameterRow(
                        parameter = LocalDetailsStrings.current.maximum,
                        value = buildAnnotatedString {
                            withStyle(SpanStyle(color = Color.White)) {
                                append("${weatherDetail.temperatureInfo.maxTemperature}° ")
                            }
                            withStyle(SpanStyle(color = Color.White.copy(alpha = .4f))) {
                                append("(${weatherDetail.temperatureInfo.maxApparentTemperature}°)")
                            }
                        },
                        valueTextStyle = TextStyle(
                            fontFamily = LocalTextStyle.current.fontFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp
                        )
                    )

                    ParameterRow(
                        parameter = LocalDetailsStrings.current.minimum,
                        value = buildAnnotatedString {
                            withStyle(SpanStyle(color = Color.White)) {
                                append("${weatherDetail.temperatureInfo.minTemperature}° ")
                            }
                            withStyle(SpanStyle(color = Color.White.copy(alpha = .4f))) {
                                append("(${weatherDetail.temperatureInfo.minApparentTemperature}°)")
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
                title = {
                    Image(
                        modifier = Modifier.size(20.dp),
                        painter = painterResource(Res.drawable.precipitation_svg),
                        contentDescription = null
                    )
                    Text(
                        text = LocalDetailsStrings.current.precipitationSectionTitle,
                        style = LocalTextStyle.current,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = Color.White
                    )
                },
                content = {

                    PrecipitationChart(
                        modifier = Modifier.heightIn(max = 300.dp),
                        probabilities = weatherDetail.precipitationInfo.probabilities
                    )

                    ParameterRow(
                        parameter = LocalDetailsStrings.current.precipitationHours,
                        value = "${weatherDetail.precipitationInfo.hours}" +
                                " ${LocalDetailsStrings.current.hourUnit}"
                    )

                    ParameterRow(
                        parameter = LocalDetailsStrings.current.sumPrecipitation,
                        value = "${weatherDetail.precipitationInfo.sum}" +
                                " ${LocalDetailsStrings.current.sumUnit}"
                    )
                }
            )
        }

        item {
            if (platformName == PlatformName.ANDROID || platformName == PlatformName.IOS) {
                DiagramSectionMobile(
                    modifier = Modifier.fillMaxWidth(),
                    weatherDetail = weatherDetail,
                )
            } else {
                DiagramSectionDesktop(
                    modifier = Modifier.fillMaxWidth(),
                    weatherDetail = weatherDetail,
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