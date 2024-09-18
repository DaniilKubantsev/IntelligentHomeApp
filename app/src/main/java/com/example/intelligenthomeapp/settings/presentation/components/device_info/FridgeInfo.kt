package com.example.intelligenthomeapp.settings.presentation.components.device_info

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.intelligenthomeapp.settings.data.device.Device
import com.example.intelligenthomeapp.ui.theme.RevercedPrimary
import com.example.intelligenthomeapp.ui.theme.SecondaryText

@Composable
fun FridgeInfo(device: Device.Fridge) {
    Text(
        text = "Target temperature: ${String.format("%.1f", device.targetTemperature.value) } °C",
        style = MaterialTheme.typography.titleMedium,
        color = SecondaryText
    )
    Text(
        text = "Current temperature: ${String.format("%.1f", device.currentTemperature.value) } °C",
        style = MaterialTheme.typography.titleMedium,
        color = SecondaryText
    )

    Spacer(modifier = Modifier.height(10.dp))
}