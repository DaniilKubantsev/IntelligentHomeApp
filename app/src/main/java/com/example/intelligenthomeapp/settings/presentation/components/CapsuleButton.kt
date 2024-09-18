package com.example.intelligenthomeapp.settings.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.intelligenthomeapp.ui.theme.RevercedPrimary
import com.example.intelligenthomeapp.ui.theme.RevercedPrimaryText
import com.example.intelligenthomeapp.ui.theme.padM

@Composable
fun CapsuleButton(
    text: String,
    icon: ImageVector,
    onClick: () -> Unit,
    enabled: Boolean = true,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .shadow(4.dp, CircleShape)
            .background(color = RevercedPrimary, shape = CircleShape)
            .padding(vertical = 5.dp, horizontal = padM)
            .clickable(
                onClick = { onClick() },
                enabled = enabled
            )

    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium,
            color = RevercedPrimaryText,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.width(padM /2))
        Icon(
            imageVector = icon,
            contentDescription = "",
            tint = RevercedPrimaryText
        )
    }
}

@Composable
fun CapsuleButton(
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .shadow(4.dp, CircleShape)
            .background(color = RevercedPrimary, shape = CircleShape)
            .padding(vertical = 5.dp, horizontal = padM)
            .clickable(
                onClick = { onClick() },
                enabled = enabled
            )

    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium,
            color = RevercedPrimaryText,
            modifier = Modifier
        )
    }
}