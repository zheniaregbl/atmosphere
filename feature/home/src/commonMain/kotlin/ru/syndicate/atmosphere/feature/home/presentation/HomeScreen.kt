package ru.syndicate.atmosphere.feature.home.presentation

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
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import atmosphere.feature.home.generated.resources.Res
import atmosphere.feature.home.generated.resources.detail_forecast_desc
import atmosphere.feature.home.generated.resources.detail_forecast_title
import atmosphere.feature.home.generated.resources.screen_title
import atmosphere.feature.home.generated.resources.some_day_forecast_desc
import atmosphere.feature.home.generated.resources.some_day_forecast_title
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import dev.chrisbanes.haze.HazeState
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import ru.syndicate.atmosphere.core.navigation.SharedScreen
import ru.syndicate.atmosphere.feature.home.presentation.components.DescriptionSection
import ru.syndicate.atmosphere.feature.home.presentation.components.ForecastSection
import ru.syndicate.atmosphere.feature.home.presentation.components.NavigateBlock
import ru.syndicate.atmosphere.feature.home.presentation.components.TopPanel
import ru.syndicate.atmosphere.feature.home.presentation.components.WeatherImage
import ru.syndicate.atmosphere.feature.home.presentation.components.WeatherParameterSection

class HomeScreen : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow
        val searchScreen = rememberScreen(SharedScreen.SearchScreen)
        val settingsScreen = rememberScreen(SharedScreen.SettingsScreen)

        val viewModel = koinViewModel<HomeViewModel>()
        val state = viewModel.state.collectAsStateWithLifecycle()

        HomeScreenImpl(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding(),
            state = state,
            currentTown = state.value.currentLocation.title,
            onAction = { viewModel.onAction(it) },
            onSearchClick = { navigator.push(searchScreen) },
            onSettingsClick = { navigator.push(settingsScreen) }
        )
    }
}

@Composable
internal fun HomeScreenImpl(
    modifier: Modifier = Modifier,
    state: State<HomeState>,
    currentTown: String,
    onAction: (HomeAction) -> Unit,
    onSearchClick: () -> Unit,
    onSettingsClick: () -> Unit
) {

    val hazeState = remember { HazeState() }

    val lazyListState = rememberLazyListState()

    val screenTitle = stringResource(Res.string.screen_title)
    val topPanelTitle = remember { mutableStateOf(screenTitle) }

    LaunchedEffect(lazyListState.firstVisibleItemIndex) {
        if (lazyListState.firstVisibleItemIndex > 0)
            topPanelTitle.value = currentTown
        else topPanelTitle.value = screenTitle
    }

    Box(modifier = modifier) {

        WeatherImage(
            modifier = Modifier
                .height(380.dp)
                .fillMaxWidth(),
            hazeState = hazeState,
            state = state
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            TopPanel(
                modifier = Modifier
                    .widthIn(max = 800.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                topPanelTitle = topPanelTitle,
                onSearchClick = onSearchClick,
                onSettingsClick = onSettingsClick
            )

            LazyColumn(
                modifier = Modifier
                    .widthIn(max = 800.dp)
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
                    WeatherParameterSection(
                        modifier = Modifier.fillMaxWidth(),
                        state = state,
                        hazeState = hazeState,
                        onRefreshClick = { onAction(HomeAction.UpdateWeatherInfo) }
                    )
                }

                item {
                    ForecastSection(
                        modifier = Modifier.fillMaxWidth(),
                        state = state
                    )
                }

                item {
                    DescriptionSection(
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .height(IntrinsicSize.Min)
                            .fillMaxWidth(),
                        state = state,
                        hazeState = hazeState
                    )
                }

                item {
                    NavigateBlock(
                        modifier = Modifier.fillMaxWidth(),
                        title = stringResource(Res.string.detail_forecast_title),
                        description = stringResource(Res.string.detail_forecast_desc),
                        hazeState = hazeState
                    )
                }

                item {
                    NavigateBlock(
                        modifier = Modifier.fillMaxWidth(),
                        title = stringResource(Res.string.some_day_forecast_title),
                        description = stringResource(Res.string.some_day_forecast_desc),
                        hazeState = hazeState
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