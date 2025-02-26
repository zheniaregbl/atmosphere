package ru.syndicate.atmosphere

import androidx.compose.animation.core.Ease
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.annotation.ExperimentalVoyagerApi
import cafe.adriel.voyager.jetpack.ProvideNavigatorLifecycleKMPSupport
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.NavigatorDisposeBehavior
import cafe.adriel.voyager.transitions.FadeTransition
import org.jetbrains.compose.ui.tooling.preview.Preview
import ru.syndicate.atmosphere.core.presentation.theme.AppTheme
import ru.syndicate.atmosphere.core.presentation.theme.BackgroundColor
import ru.syndicate.atmosphere.feature.splash.presentation.SplashScreen

@OptIn(ExperimentalVoyagerApi::class)
@Composable
@Preview
fun App() {

    AppTheme {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundColor)
        ) {

            ProvideNavigatorLifecycleKMPSupport {

                Navigator(
                    screen = SplashScreen(),
                    disposeBehavior = NavigatorDisposeBehavior(disposeSteps = false)
                ) { navigator ->

                    FadeTransition(
                        navigator = navigator,
                        animationSpec = tween(
                            durationMillis = 180,
                            easing = Ease,
                            delayMillis = 100
                        ),
                        disposeScreenAfterTransitionEnd = true
                    )
                }
            }
        }
    }
}