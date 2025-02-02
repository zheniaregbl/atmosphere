package ru.syndicate.atmosphere.feature.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import atmosphere.feature.home.generated.resources.Res
import atmosphere.feature.home.generated.resources.arrow_right_svg
import dev.chrisbanes.haze.HazeDefaults
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.HazeTint
import dev.chrisbanes.haze.hazeChild
import org.jetbrains.compose.resources.painterResource
import ru.syndicate.atmosphere.core.presentation.theme.BackgroundColor
import ru.syndicate.atmosphere.core.presentation.util.extension.scaleOnClick

@Composable
internal fun NavigateBlock(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    hazeState: HazeState,
    onClick: (() -> Unit)? = null
) {

    Row(
        modifier = modifier
            .scaleOnClick(0.96f)
            .clip(RoundedCornerShape(8.dp))
            .hazeChild(
                state = hazeState,
                style = HazeDefaults
                    .style(
                        backgroundColor = BackgroundColor,
                        tint = HazeTint(color = Color.DarkGray.copy(alpha = .5f)),
                        blurRadius = 8.dp,
                    )
            )
            .clickable(
                onClick = onClick ?: { },
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            )
            .padding(16.dp)
    ) {

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                color = Color.White
            )

            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.width(20.dp))

        Image(
            painter = painterResource(Res.drawable.arrow_right_svg),
            contentDescription = null
        )
    }
}