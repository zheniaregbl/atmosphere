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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.lyricist.ProvideStrings
import cafe.adriel.lyricist.rememberStrings
import cafe.adriel.voyager.core.annotation.InternalVoyagerApi
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.internal.BackHandler
import dev.chrisbanes.haze.HazeState
import org.koin.compose.viewmodel.koinViewModel
import ru.syndicate.atmosphere.core.navigation.SharedScreen
import ru.syndicate.atmosphere.core.presentation.components.ErrorDialog
import ru.syndicate.atmosphere.core.presentation.translation.Locales
import ru.syndicate.atmosphere.feature.home.presentation.components.DescriptionSection
import ru.syndicate.atmosphere.feature.home.presentation.components.ForecastSection
import ru.syndicate.atmosphere.feature.home.presentation.components.NavigateBlock
import ru.syndicate.atmosphere.feature.home.presentation.components.TopPanel
import ru.syndicate.atmosphere.feature.home.presentation.components.WeatherImage
import ru.syndicate.atmosphere.feature.home.presentation.components.WeatherParameterSection
import ru.syndicate.atmosphere.feature.home.presentation.translation.util.LocalHomeStrings
import ru.syndicate.atmosphere.feature.home.presentation.translation.util.TranslationUtil.translations
import ru.syndicate.atmosphere.feature.home.presentation.util.ErrorMessageCode

internal class HomeScreen : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow
        val searchScreen = rememberScreen(SharedScreen.SearchScreen(isInitSelect = false))
        val settingsScreen = rememberScreen(SharedScreen.SettingsScreen)
        val weatherDetailScreen = rememberScreen(SharedScreen.WeatherDetail)
        val forecastScreen = rememberScreen(SharedScreen.ForecastScreen)

        val viewModel = koinViewModel<HomeViewModel>()
        val state = viewModel.state.collectAsStateWithLifecycle()

        HomeScreenImpl(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding(),
            state = state,
            currentTown = state.value.currentLocation.title,
            onAction = {
                when (it) {
                    HomeAction.NavigateToDetail -> navigator.push(weatherDetailScreen)
                    HomeAction.NavigateToForecast -> navigator.push(forecastScreen)
                    else -> viewModel.onAction(it)
                }
            },
            onSearchClick = { navigator.push(searchScreen) },
            onSettingsClick = { navigator.push(settingsScreen) }
        )
    }
}

@OptIn(InternalVoyagerApi::class)
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

    val lyricist = rememberStrings(
        translations = translations,
        defaultLanguageTag = Locales.EN,
        currentLanguageTag = state.value.appLanguage
    )

    var isShowedTownTitle by remember { mutableStateOf(false) }

    BackHandler(
        enabled = state.value.showErrorDialog,
        onBack = { onAction(HomeAction.OnCloseErrorDialog) }
    )

    LaunchedEffect(state.value.appLanguage) {
        lyricist.languageTag = state.value.appLanguage
    }

    ProvideStrings(
        lyricist = lyricist,
        provider = LocalHomeStrings
    ) {

        LaunchedEffect(lazyListState.firstVisibleItemIndex) {
            isShowedTownTitle = lazyListState.firstVisibleItemIndex > 0
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
                    currentLocation = state.value.currentLocation,
                    isShowedTownTitle = isShowedTownTitle,
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
                        state.value.toUiState().DisplayResult(
                            modifier = Modifier.fillMaxWidth(),
                            onLoading = { },
                            onSuccess = { screenState ->
                                DescriptionSection(
                                    modifier = Modifier
                                        .padding(top = 10.dp)
                                        .height(IntrinsicSize.Min)
                                        .fillMaxWidth(),
                                    weatherInfo = screenState.weatherInfo,
                                    hazeState = hazeState
                                )
                            },
                            onError = {}
                        )
                    }

                    item {
                        NavigateBlock(
                            modifier = Modifier.fillMaxWidth(),
                            title = LocalHomeStrings.current.detailForecastTitle,
                            description = LocalHomeStrings.current.detailForecastDesc,
                            hazeState = hazeState,
                            onClick = { onAction(HomeAction.NavigateToDetail) }
                        )
                    }

                    item {
                        NavigateBlock(
                            modifier = Modifier.fillMaxWidth(),
                            title = LocalHomeStrings.current.someDayForecastTitle,
                            description = LocalHomeStrings.current.someDayForecastDesc,
                            hazeState = hazeState,
                            onClick = { onAction(HomeAction.NavigateToForecast) }
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

        ErrorDialog(
            showDialog = state.value.showErrorDialog,
            title = LocalHomeStrings.current.errorStrings.dialogTitle,
            description = when (state.value.errorMessageCode) {
                ErrorMessageCode.REQUEST_ERROR -> LocalHomeStrings.current.errorStrings.error
                ErrorMessageCode.REQUEST_EXCEPTION -> LocalHomeStrings.current.errorStrings.exception
                else -> ""
            },
            onDismissRequest = { onAction(HomeAction.OnCloseErrorDialog) }
        )
    }
}