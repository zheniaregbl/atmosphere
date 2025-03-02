package ru.syndicate.atmosphere.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.atmosphere.core.presentation.theme.BackgroundColor

@Composable
fun ErrorDialog(
    showDialog: Boolean,
    title: String,
    description: String,
    onDismissRequest: () -> Unit = { }
) {

    DialogPopup(
        showDialog = showDialog,
        onDismissRequest = onDismissRequest
    ) {

        ErrorDialogUI(
            modifier = Modifier
                .fillMaxWidth()
                .background(BackgroundColor)
                .padding(
                    horizontal = 14.dp,
                    vertical = 18.dp
                ),
            title = title,
            description = description,
            onDismissRequest = onDismissRequest
        )
    }
}

@Composable
private fun ErrorDialogUI(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    onDismissRequest: () -> Unit
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        Text(
            text = title,
            style = LocalTextStyle.current,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            color = Color.White
        )

        Text(
            text = description,
            style = LocalTextStyle.current,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = Color.White
        )

        ActionButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            text = "OK",
            isConfirm = false,
            onClick = onDismissRequest
        )
    }
}