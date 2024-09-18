package com.example.intelligenthomeapp.settings.presentation.components.device_edit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.intelligenthomeapp.settings.data.device.Device
import com.example.intelligenthomeapp.settings.presentation.components.CapsuleButton
import com.example.intelligenthomeapp.settings.presentation.screens.SettingsEvent
import com.example.intelligenthomeapp.ui.theme.RevercedPrimary
import com.example.intelligenthomeapp.ui.theme.padL

@Composable
fun FridgeEdit(
    device: Device.Fridge,
    onEvent: (SettingsEvent) -> Unit,
) {
    var target by remember { mutableFloatStateOf(device.targetTemperature.value) }
    Column {
        Text(text = "Target Temperature: ${String.format("%.1f", target)}")
        Slider(
            value = target,
            onValueChange = { target = it },
            valueRange = 0f..60f,
            colors = SliderDefaults.colors(
                thumbColor = RevercedPrimary,
                activeTrackColor = RevercedPrimary,
                inactiveTickColor = RevercedPrimary
            )
        )
        CapsuleButton(
            text = "Apply",
            onClick = {
                onEvent(
                    SettingsEvent.ChangeTemperature(
                        id = device.id,
                        t = target,
                    )
                )
                onEvent(SettingsEvent.EditDevice(device.id))
            },
            modifier = Modifier
                .padding(horizontal = padL)
                .fillMaxWidth()
        )
    }
}