package ru.syndicate.atmosphere.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.atmosphere.core.presentation.theme.SelectedBlue
import ru.syndicate.atmosphere.core.presentation.util.extension.scaleOnClick

@Composable
fun ConfirmButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {

    Box(
        modifier = modifier
            .scaleOnClick(0.96f)
            .clip(RoundedCornerShape(10.dp))
            .clickable(
                onClick = onClick,
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            )
            .background(SelectedBlue.copy(alpha = .4f))
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = text,
            style = LocalTextStyle.current,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = SelectedBlue
        )
    }
}