package ru.syndicate.atmosphere.feature.settings.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import ru.syndicate.atmosphere.core.presentation.theme.SelectedBlue
import ru.syndicate.atmosphere.feature.settings.presentation.theme.DescriptionColor
import ru.syndicate.atmosphere.feature.settings.resources.Res
import ru.syndicate.atmosphere.feature.settings.resources.arrow_right_svg

@Composable
internal fun SettingParameter(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    value: String? = null,
    onClick: () -> Unit
) {

    Row(
        modifier = modifier
            .clickable(
                onClick = onClick,
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column(
            modifier = Modifier.weight(1f),
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
        }

        Spacer(modifier = Modifier.width(30.dp))

        if (value != null) {
            Text(
                text = value,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                color = SelectedBlue
            )
        } else {
            Image(
                painter = painterResource(Res.drawable.arrow_right_svg),
                contentDescription = null
            )
        }
    }
}