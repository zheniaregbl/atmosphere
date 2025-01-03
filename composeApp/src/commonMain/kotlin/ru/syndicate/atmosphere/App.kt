package ru.syndicate.atmosphere

import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.FadeTransition
import org.jetbrains.compose.ui.tooling.preview.Preview
import ru.syndicate.atmosphere.presentation.screen.home.HomeScreen
import ru.syndicate.atmosphere.presentation.theme.AppTheme
import ru.syndicate.atmosphere.presentation.theme.BackgroundColor

@Composable
@Preview
fun App() {

    AppTheme {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = BackgroundColor)
        ) {

            Navigator(HomeScreen()) { navigator ->

                FadeTransition(
                    navigator = navigator,
                    animationSpec = tween(durationMillis = 200)
                )
            }
        }
    }
}