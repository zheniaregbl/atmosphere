package ru.syndicate.atmosphere.feature.settings.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import ru.syndicate.atmosphere.core.presentation.theme.LightWhite
import ru.syndicate.atmosphere.feature.settings.resources.Res
import ru.syndicate.atmosphere.feature.settings.resources.arrow_left_svg
import ru.syndicate.atmosphere.feature.settings.resources.arrow_svg

@Composable
internal fun TopPanel(
    modifier: Modifier = Modifier,
    topPanelTitle: String,
    onBackClick: () -> Unit
) {

    Box(modifier = modifier) {

        Image(
            modifier = Modifier
                .size(28.dp)
                .clickable(
                    onClick = onBackClick,
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ),
            painter = painterResource(Res.drawable.arrow_left_svg),
            contentDescription = null
        )

        Row(
            modifier = Modifier.align(Alignment.Center),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(Res.drawable.arrow_svg),
                contentDescription = null
            )

            Text(
                text = topPanelTitle,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = LightWhite
            )
        }
    }
}