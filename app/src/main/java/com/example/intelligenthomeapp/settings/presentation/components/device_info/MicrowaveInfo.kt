package com.example.intelligenthomeapp.settings.presentation.components.device_info

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.intelligenthomeapp.settings.data.device.Device
import com.example.intelligenthomeapp.ui.theme.SecondaryText

@Composable
fun MicrowaveInfo(
    device: Device.Microwave
) {
    Text(
        text = "Timer: ${device.timer.value} Sec",
        style = MaterialTheme.typography.titleMedium,
        color = SecondaryText
    )
    Text(
        text = "Power: ${device.power.value} WT",
        style = MaterialTheme.typography.titleMedium,
        color = SecondaryText
    )
    Spacer(modifier = Modifier.height(10.dp))
}