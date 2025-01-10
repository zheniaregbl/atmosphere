package ru.syndicate.atmosphere.feature.search.presentation.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImagePainter
import coil3.compose.LocalPlatformContext
import coil3.compose.SubcomposeAsyncImage
import coil3.compose.SubcomposeAsyncImageContent
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.svg.SvgDecoder
import com.valentinilk.shimmer.ShimmerBounds
import com.valentinilk.shimmer.defaultShimmerTheme
import com.valentinilk.shimmer.rememberShimmer
import com.valentinilk.shimmer.shimmer
import com.valentinilk.shimmer.shimmerSpec

@Composable
internal fun FlagImage(
    modifier: Modifier = Modifier,
    url: String
) {

    val shimmerInstance = rememberShimmer(
        shimmerBounds = ShimmerBounds.Window,
        theme = defaultShimmerTheme.copy(
            animationSpec = infiniteRepeatable(
                animation = shimmerSpec(
                    durationMillis = 800,
                    easing = LinearEasing,
                    delayMillis = 500,
                ),
                repeatMode = RepeatMode.Restart,
            )
        )
    )

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {

        SubcomposeAsyncImage(
            modifier = Modifier.matchParentSize(),
            model = ImageRequest.Builder(LocalPlatformContext.current)
                .data(url)
                .decoderFactory(SvgDecoder.Factory())
                .crossfade(true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        ) {

            val state by painter.state.collectAsState()

            if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                Box(
                    modifier = Modifier
                        .shimmer(shimmerInstance)
                        .matchParentSize()
                        .background(color = Color.LightGray)
                )
            } else {
                SubcomposeAsyncImageContent()
            }
        }
    }
}