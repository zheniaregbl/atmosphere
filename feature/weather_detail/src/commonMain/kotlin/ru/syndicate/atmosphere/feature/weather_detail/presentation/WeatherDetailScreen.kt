package ru.syndicate.atmosphere.feature.weather_detail.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
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
import dev.chrisbanes.haze.HazeState
import org.koin.compose.viewmodel.koinViewModel
import ru.syndicate.atmosphere.core.presentation.translation.Locales
import ru.syndicate.atmosphere.feature.weather_detail.presentation.components.DetailsContent
import ru.syndicate.atmosphere.feature.weather_detail.presentation.components.TopPanel
import ru.syndicate.atmosphere.feature.weather_detail.presentation.translation.util.LocalDetailsStrings
import ru.syndicate.atmosphere.feature.weather_detail.presentation.translation.util.TranslationUtil.translations

internal class WeatherDetailScreen : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        val viewModel = koinViewModel<WeatherDetailViewModel>()
        val state = viewModel.state.collectAsStateWithLifecycle()

        WeatherDetailScreenImpl(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding(),
            state = state,
            onBackClick = { navigator.pop() }
        )
    }
}

@Composable
internal fun WeatherDetailScreenImpl(
    modifier: Modifier = Modifier,
    state: State<WeatherDetailState>,
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
                        DetailsContent(
                            modifier = Modifier
                                .widthIn(max = 800.dp)
                                .fillMaxWidth(),
                            weatherDetail = screenState.details,
                            hazeState = hazeState
                        )
                    }
                )
            }
        }
    }
}