package ru.syndicate.atmosphere.feature.forecast.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.lyricist.ProvideStrings
import cafe.adriel.lyricist.rememberStrings
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.mohamedrejeb.calf.ui.progress.AdaptiveCircularProgressIndicator
import org.koin.compose.viewmodel.koinViewModel
import ru.syndicate.atmosphere.core.presentation.components.ErrorContentWithRetry
import ru.syndicate.atmosphere.core.presentation.translation.Locales
import ru.syndicate.atmosphere.feature.forecast.presentation.components.ForecastCard
import ru.syndicate.atmosphere.feature.forecast.presentation.components.TopPanel
import ru.syndicate.atmosphere.feature.forecast.presentation.translation.util.LocalForecastStrings
import ru.syndicate.atmosphere.feature.forecast.presentation.translation.util.TranslationUtil.translations

internal class ForecastScreen : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        val viewModel = koinViewModel<ForecastViewModel>()
        val state = viewModel.state.collectAsStateWithLifecycle()

        ForecastScreenImpl(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding(),
            state = state,
            onAction = { viewModel.onAction(it) },
            onBackClick = { navigator.pop() }
        )
    }
}

@Composable
internal fun ForecastScreenImpl(
    modifier: Modifier = Modifier,
    state: State<ForecastState>,
    onAction: (ForecastAction) -> Unit,
    onBackClick: () -> Unit
) {

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
        provider = LocalForecastStrings
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
                    topPanelTitle = LocalForecastStrings.current.screenTitle,
                    onBackClick = onBackClick
                )

                state.value.toUiState().DisplayResult(
                    modifier = Modifier.fillMaxSize(),
                    onIdle = { },
                    onLoading = {
                        AdaptiveCircularProgressIndicator(
                            modifier = Modifier
                                .padding(bottom = 80.dp)
                                .size(50.dp),
                            color = Color.White,
                        )
                    },
                    onSuccess = { screenState ->

                        LazyColumn(
                            modifier = Modifier
                                .widthIn(max = 800.dp)
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {

                            items(screenState.forecasts) {
                                ForecastCard(
                                    modifier = Modifier.fillMaxWidth(),
                                    dailyForecast = it
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
                    },
                    onError = {
                        ErrorContentWithRetry(
                            modifier = Modifier
                                .widthIn(max = 400.dp)
                                .fillMaxWidth()
                                .padding(bottom = 60.dp),
                            title = LocalForecastStrings.current.errorContentStrings.title,
                            text = LocalForecastStrings.current.errorContentStrings.text,
                            buttonText = LocalForecastStrings.current.errorContentStrings.repeatText,
                            onRepeat = { onAction(ForecastAction.OnUpdate) }
                        )
                    }
                )
            }
        }
    }

}