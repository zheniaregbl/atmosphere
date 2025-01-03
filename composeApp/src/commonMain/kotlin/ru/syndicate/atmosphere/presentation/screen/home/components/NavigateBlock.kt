package ru.syndicate.atmosphere.presentation.screen.home.components

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import atmosphere.composeapp.generated.resources.Res
import atmosphere.composeapp.generated.resources.arrow_right_svg
import atmosphere.composeapp.generated.resources.arrow_svg
import org.jetbrains.compose.resources.painterResource

@Composable
fun NavigateBlock(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    onClick: (() -> Unit)? = null
) {

    Row(
        modifier = modifier
            .clickable(
                onClick = onClick ?: { },
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            )
    ) {

        Column(
            modifier = Modifier
                .weight(1f),
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