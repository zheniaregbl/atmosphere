package ru.syndicate.atmosphere.feature.search.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.mohamedrejeb.calf.ui.progress.AdaptiveCircularProgressIndicator
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import ru.syndicate.atmosphere.feature.search.presentation.components.CityCard
import ru.syndicate.atmosphere.feature.search.presentation.components.SearchBar
import ru.syndicate.atmosphere.feature.search.presentation.components.TopPanel
import ru.syndicate.atmosphere.feature.search.presentation.theme.CardColor
import ru.syndicate.atmosphere.feature.search.resources.Res
import ru.syndicate.atmosphere.feature.search.resources.screen_title
import ru.syndicate.atmosphere.feature.search.resources.searching_svg

class SearchScreen : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        val viewModel = koinViewModel<CityListViewModel>()
        val state = viewModel.state.collectAsStateWithLifecycle()

        LaunchedEffect(state.value.savedCity) {
            if (state.value.savedCity != null) {
                navigator.pop()
            }
        }

        CityListScreenImpl(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding(),
            state = state,
            onAction = { action ->
                viewModel.onAction(action)
            },
            onBackClick = { navigator.pop() }
        )

        DisposableEffect(Unit) {
            onDispose {
                viewModel.onAction(CityListAction.ClearData)
            }
        }
    }
}

@Composable
internal fun CityListScreenImpl(
    modifier: Modifier = Modifier,
    state: State<CityListState>,
    onAction: (CityListAction) -> Unit,
    onBackClick: () -> Unit
) {

    val keyboardController = LocalSoftwareKeyboardController.current

    Box(modifier = modifier) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp)
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {

            TopPanel(
                modifier = Modifier
                    .widthIn(max = 800.dp)
                    .fillMaxWidth(),
                topPanelTitle = stringResource(Res.string.screen_title),
                onBackClick = onBackClick
            )

            SearchBar(
                modifier = Modifier
                    .widthIn(max = 800.dp)
                    .fillMaxWidth(),
                value = state.value.searchCityText,
                onValueChange = {
                    onAction(CityListAction.OnSearchCityChange(it))
                },
                onImeSearch = { keyboardController?.hide() }
            )

            state.value.toUiState().DisplayResult(
                modifier = Modifier.fillMaxSize(),
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
                        verticalArrangement = Arrangement.spacedBy(14.dp)
                    ) {

                        items(screenState.cityList) {
                            CityCard(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .fillMaxWidth()
                                    .background(CardColor),
                                city = it,
                                onClick = { onAction(CityListAction.OnCityClick(it)) }
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
                onError = { screenState ->

                    Column(
                        modifier = Modifier
                            .widthIn(max = 400.dp)
                            .fillMaxWidth()
                            .padding(bottom = 80.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {

                        Image(
                            painter = painterResource(Res.drawable.searching_svg),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(Color.White)
                        )

                        Text(
                            text = screenState.errorMessage,
                            style = LocalTextStyle.current,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            color = Color.White
                        )
                    }
                }
            )
        }
    }
}