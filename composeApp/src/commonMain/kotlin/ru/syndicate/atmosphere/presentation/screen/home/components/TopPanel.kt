package ru.syndicate.atmosphere.presentation.screen.home.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import atmosphere.composeapp.generated.resources.Res
import atmosphere.composeapp.generated.resources.arrow_svg
import atmosphere.composeapp.generated.resources.search_svg
import atmosphere.composeapp.generated.resources.settings_svg
import org.jetbrains.compose.resources.painterResource
import ru.syndicate.atmosphere.presentation.theme.LightWhite

@Composable
fun TopPanel(
    modifier: Modifier = Modifier,
    topPanelTitle: MutableState<String>,
    onSearchClick: () -> Unit,
    onSettingsClick: () -> Unit
) {

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            modifier = Modifier
                .clickable(
                    onClick = onSearchClick,
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                ),
            painter = painterResource(Res.drawable.search_svg),
            contentDescription = null
        )

        Row(
            modifier = Modifier.padding(10.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(Res.drawable.arrow_svg),
                contentDescription = null
            )

            AnimatedContent(
                targetState = topPanelTitle.value
            ) { title ->

                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = LightWhite
                )
            }
        }

        Image(
            modifier = Modifier
                .clickable(
                    onClick = onSettingsClick,
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                ),
            painter = painterResource(Res.drawable.settings_svg),
            contentDescription = null
        )
    }
}