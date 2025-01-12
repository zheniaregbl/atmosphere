package ru.syndicate.atmosphere.feature.search.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.mohamedrejeb.calf.ui.progress.AdaptiveCircularProgressIndicator
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import ru.syndicate.atmosphere.feature.search.presentation.components.CityCard
import ru.syndicate.atmosphere.feature.search.presentation.components.SearchBar
import ru.syndicate.atmosphere.feature.search.presentation.theme.CardColor
import ru.syndicate.atmosphere.feature.search.resources.Res
import ru.syndicate.atmosphere.feature.search.resources.arrow_left_svg

class SearchScreen : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        val viewModel = koinViewModel<CityListViewModel>()
        val state = viewModel.state.collectAsStateWithLifecycle()

        CityListScreenImpl(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding(),
            state = state,
            onAction = { action ->
                viewModel.onAction(action)
                when (action) {
                    is CityListAction.OnCityClick -> navigator.pop()
                    else -> Unit
                }
            },
            onBackClick = { navigator.pop() }
        )
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

            Row(
                modifier = Modifier
                    .widthIn(max = 800.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    modifier = Modifier.clickable(
                        onClick = onBackClick,
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ),
                    painter = painterResource(Res.drawable.arrow_left_svg),
                    contentDescription = null
                )
            }

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
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        AdaptiveCircularProgressIndicator(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .padding(bottom = 80.dp)
                                .size(50.dp),
                            color = Color.White,
                        )
                    }
                },
                onError = {
                    Text("error")
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
                }
            )
        }
    }
}