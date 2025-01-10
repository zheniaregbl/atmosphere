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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.jetbrains.compose.resources.painterResource
import ru.syndicate.atmosphere.feature.search.domain.City
import ru.syndicate.atmosphere.feature.search.presentation.components.CityCard
import ru.syndicate.atmosphere.feature.search.presentation.components.SearchBar
import ru.syndicate.atmosphere.feature.search.presentation.theme.CardColor
import ru.syndicate.atmosphere.feature.search.resources.Res
import ru.syndicate.atmosphere.feature.search.resources.arrow_left_svg

class SearchScreen : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        SearchScreenImpl(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding(),
            onBackClick = { navigator.pop() }
        )
    }
}

@Composable
internal fun SearchScreenImpl(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
) {

    var searchText by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    val cityList = listOf(City(), City(), City(), City(), City(), City(), City())

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
                value = searchText,
                onValueChange = { searchText = it },
                onImeSearch = { keyboardController?.hide() }
            )

            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {

                items(cityList) {
                    CityCard(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .fillMaxWidth()
                            .background(CardColor),
                        city = it,
                        onClick = { }
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