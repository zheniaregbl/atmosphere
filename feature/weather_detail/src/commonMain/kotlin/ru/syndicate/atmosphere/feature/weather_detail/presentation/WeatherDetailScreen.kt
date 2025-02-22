package ru.syndicate.atmosphere.feature.weather_detail.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.lyricist.ProvideStrings
import cafe.adriel.lyricist.rememberStrings
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import dev.chrisbanes.haze.HazeState
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import ru.syndicate.atmosphere.core.presentation.translation.Locales
import ru.syndicate.atmosphere.core.util.PlatformName
import ru.syndicate.atmosphere.core.util.platformName
import ru.syndicate.atmosphere.feature.weather_detail.presentation.components.DiagramSectionDesktop
import ru.syndicate.atmosphere.feature.weather_detail.presentation.components.DiagramSectionMobile
import ru.syndicate.atmosphere.feature.weather_detail.presentation.components.ParameterCard
import ru.syndicate.atmosphere.feature.weather_detail.presentation.components.ParameterRow
import ru.syndicate.atmosphere.feature.weather_detail.presentation.components.PrecipitationChart
import ru.syndicate.atmosphere.feature.weather_detail.presentation.components.TemperatureChart
import ru.syndicate.atmosphere.feature.weather_detail.presentation.components.TopPanel
import ru.syndicate.atmosphere.feature.weather_detail.presentation.translation.util.LocalDetailsStrings
import ru.syndicate.atmosphere.feature.weather_detail.presentation.translation.util.TranslationUtil.translations
import ru.syndicate.atmosphere.feature.weather_detail.resources.Res
import ru.syndicate.atmosphere.feature.weather_detail.resources.precipitation_svg
import ru.syndicate.atmosphere.feature.weather_detail.resources.temperature_svg
import kotlin.random.Random

internal class WeatherDetailScreen : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        val viewModel = koinViewModel<WeatherDetailViewModel>()
        val state = viewModel.state.collectAsStateWithLifecycle()

        WeatherDetailScreenImpl(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding(),
            state = state,
            platformName = platformName(),
            onBackClick = { navigator.pop() }
        )
    }
}

@Composable
internal fun WeatherDetailScreenImpl(
    modifier: Modifier = Modifier,
    state: State<WeatherDetailState>,
    platformName: String,
    onBackClick: () -> Unit
) {

    val hazeState = remember { HazeState() }

    val lyricist = rememberStrings(
        translations = translations,
        defaultLanguageTag = Locales.EN,
        currentLanguageTag = state.value.appLanguage
    )

    LaunchedEffect(state.value.appLanguage) {
        lyricist.languageTag = state.value.appLanguage
    }

    ProvideStrings(
        lyricist = lyricist,
        provider = LocalDetailsStrings
    ) {

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
                    topPanelTitle = LocalDetailsStrings.current.screenTitle,
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
                                    temperatures = listOf(15, 14, 13, 16, 18, 19, 20, 21, 22, 21, 20, 18, 17, 16, 15, 15, 15, 13, 12, 9, 10, 10, 9, 9)
                                )

                                ParameterRow(
                                    parameter = LocalDetailsStrings.current.maximum,
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
                                    parameter = LocalDetailsStrings.current.minimum,
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
                                    text = LocalDetailsStrings.current.precipitationSectionTitle,
                                    style = LocalTextStyle.current,
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 14.sp,
                                    color = Color.White
                                )
                            },
                            content = {

                                val probabilities by remember {
                                    mutableStateOf(
                                        (0..23).map { Random.nextInt(0, 100) }
                                    )
                                }

                                PrecipitationChart(
                                    modifier = Modifier.heightIn(max = 300.dp),
                                    probabilities = probabilities
                                )

                                ParameterRow(
                                    parameter = LocalDetailsStrings.current.precipitationProbability,
                                    value = "45 %"
                                )

                                ParameterRow(
                                    parameter = LocalDetailsStrings.current.precipitationHours,
                                    value = "2 ${LocalDetailsStrings.current.hourUnit}"
                                )

                                ParameterRow(
                                    parameter = LocalDetailsStrings.current.sumPrecipitation,
                                    value = "100 ${LocalDetailsStrings.current.sumUnit}"
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

}