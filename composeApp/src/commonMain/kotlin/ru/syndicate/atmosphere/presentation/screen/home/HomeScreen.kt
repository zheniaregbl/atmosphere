package ru.syndicate.atmosphere.presentation.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import atmosphere.composeapp.generated.resources.Res
import cafe.adriel.voyager.core.screen.Screen
import dev.chrisbanes.haze.HazeDefaults
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.HazeTint
import dev.chrisbanes.haze.haze
import dev.chrisbanes.haze.hazeChild
import io.github.alexzhirkevich.compottie.Compottie
import io.github.alexzhirkevich.compottie.LottieCompositionSpec
import io.github.alexzhirkevich.compottie.animateLottieCompositionAsState
import io.github.alexzhirkevich.compottie.rememberLottieComposition
import io.github.alexzhirkevich.compottie.rememberLottiePainter
import org.jetbrains.compose.resources.ExperimentalResourceApi
import ru.syndicate.atmosphere.presentation.screen.home.components.DescriptionSection
import ru.syndicate.atmosphere.presentation.screen.home.components.ForecastSection
import ru.syndicate.atmosphere.presentation.screen.home.components.MainInfoSection
import ru.syndicate.atmosphere.presentation.screen.home.components.NavigateBlock
import ru.syndicate.atmosphere.presentation.screen.home.components.TopPanel
import ru.syndicate.atmosphere.presentation.theme.BackgroundColor

class HomeScreen : Screen {

    @Composable
    override fun Content() {
        HomeScreenImpl(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding(),
            currentTown = "Moscow"
        )
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun HomeScreenImpl(
    modifier: Modifier = Modifier,
    currentTown: String,
) {

    val hazeState = remember { HazeState() }

    val lazyListState = rememberLazyListState()

    val topPanelTitle = remember { mutableStateOf("Home") }

    val composition by rememberLottieComposition {
        LottieCompositionSpec.JsonString(
            Res.readBytes("files/sun_rain.json").decodeToString()
        )
    }
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = Compottie.IterateForever
    )

    LaunchedEffect(lazyListState.firstVisibleItemIndex) {
        println(lazyListState.firstVisibleItemIndex)
        if (lazyListState.firstVisibleItemIndex > 0)
            topPanelTitle.value = currentTown
        else topPanelTitle.value = "Home"
    }

    Box(modifier = modifier) {

        Image(
            modifier = Modifier
                .height(440.dp)
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(top = 80.dp)
                .padding(horizontal = 50.dp)
                .alpha(0.35f)
                .haze(hazeState),
            painter = rememberLottiePainter(
                composition = composition,
                progress = { progress },
            ),
            contentDescription = null
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 26.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            TopPanel(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp),
                topPanelTitle = topPanelTitle,
                onSearchClick = { },
                onSettingsClick = { }
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp),
                state = lazyListState,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                item {
                    Text(
                        text = currentTown,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                        fontSize = 30.sp,
                        color = Color.White
                    )
                }

                item {
                    MainInfoSection(
                        modifier = Modifier.fillMaxWidth(),
                        hazeState = hazeState
                    )
                }

                item {
                    ForecastSection(modifier = Modifier.fillMaxWidth())
                }

                item {
                    DescriptionSection(
                        modifier = Modifier
                            .height(IntrinsicSize.Min)
                            .fillMaxWidth()
                            .padding(vertical = 10.dp),
                        hazeState = hazeState
                    )
                }

                item {
                    NavigateBlock(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .hazeChild(
                                state = hazeState,
                                style = HazeDefaults
                                    .style(
                                        backgroundColor = BackgroundColor,
                                        tint = HazeTint(color = Color.DarkGray.copy(alpha = .5f)),
                                        blurRadius = 8.dp,
                                    )
                            )
                            .padding(16.dp),
                        title = "Detailed forecast",
                        description = "check out the weather forecast for today and more."
                    )
                }

                item {
                    NavigateBlock(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .hazeChild(
                                state = hazeState,
                                style = HazeDefaults
                                    .style(
                                        backgroundColor = BackgroundColor,
                                        tint = HazeTint(color = Color.DarkGray.copy(alpha = .5f)),
                                        blurRadius = 8.dp,
                                    )
                            )
                            .padding(16.dp),
                        title = "7 day forecast",
                        description = "View a quick overview of the weather forecast for the next 7 days."
                    )
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