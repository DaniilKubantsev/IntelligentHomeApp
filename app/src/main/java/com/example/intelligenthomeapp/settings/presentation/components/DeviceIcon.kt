package com.example.intelligenthomeapp.settings.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.example.intelligenthomeapp.settings.presentation.screens.SettingsEvent
import com.example.intelligenthomeapp.ui.theme.DeviceOffline
import com.example.intelligenthomeapp.ui.theme.DeviceOnline
import com.example.intelligenthomeapp.ui.theme.PrimaryText

@Composable
fun DeviceIcon(
    painter: Painter,
    online: Boolean,
    onlineColor: Color,
    offlineColor: Color,
    onClick: () -> Unit,
) {
    var indicatorColor by remember { mutableStateOf(DeviceOnline) }
    indicatorColor = if (online) onlineColor else offlineColor

    Box(
       contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painter,
            contentDescription = "",
            modifier = Modifier
                .size(40.dp)
                .clickable(
                    onClick = { onClick() }
                ),
            tint = PrimaryText
        )
        Box(
            modifier = Modifier
                .background(color = indicatorColor, shape = CircleShape)
                .size(10.dp)
                .align(Alignment.BottomEnd)
        ){}
    }

}


@Composable
fun DeviceIcon(
    painter: Painter,
    online: Boolean,
) {

    Icon(
        painter = painter,
        contentDescription = "",
        modifier = Modifier
            .size(40.dp),
        tint = PrimaryText
    )

}



