package ru.syndicate.atmosphere.feature.settings.presentation.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.atmosphere.core.presentation.theme.SelectedBlue
import ru.syndicate.atmosphere.feature.settings.presentation.theme.DescriptionColor
import ru.syndicate.atmosphere.feature.settings.presentation.translation.util.TranslationUtil.LocalSettingsStrings

@Composable
internal fun WidgetTimingParameter(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    selectedTimingWidget: Int,
    onClick: (Int) -> Unit,
) {

    val timingTitles = listOf(
        "15 ${LocalSettingsStrings.current.minutesText}",
        "30 ${LocalSettingsStrings.current.minutesText}",
        "1 ${LocalSettingsStrings.current.hoursText}"
    )

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(6.dp)
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
            color = DescriptionColor
        )

        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            timingTitles.forEachIndexed { index, timing ->
                TimingChip(
                    text = timing,
                    isSelected = selectedTimingWidget == index,
                    onClick = { onClick(index) }
                )
            }
        }
    }
}

@Composable
private fun TimingChip(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {

    val textColor by animateColorAsState(
        targetValue = if (isSelected) SelectedBlue else Color.White
    )

    val backgroundAlpha by animateFloatAsState(
        targetValue = if (isSelected) .4f else 0f
    )

    Text(
        modifier = Modifier
            .clip(CircleShape)
            .background(SelectedBlue.copy(alpha = backgroundAlpha))
            .clickable(
                onClick = onClick,
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            )
            .padding(
                horizontal = 10.dp,
                vertical = 6.dp
            ),
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = textColor
    )
}