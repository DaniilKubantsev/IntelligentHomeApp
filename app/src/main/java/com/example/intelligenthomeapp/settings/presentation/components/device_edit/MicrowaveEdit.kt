package com.example.intelligenthomeapp.settings.presentation.components.device_edit

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.sharp.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.example.intelligenthomeapp.settings.data.device.Device
import com.example.intelligenthomeapp.settings.presentation.components.CapsuleButton
import com.example.intelligenthomeapp.settings.presentation.screens.SettingsEvent
import com.example.intelligenthomeapp.ui.theme.RevercedPrimary
import com.example.intelligenthomeapp.ui.theme.RevercedPrimaryText
import com.example.intelligenthomeapp.ui.theme.padL

@Composable
fun MicrowaveEdit(
    device: Device.Microwave,
    onEvent: (SettingsEvent) -> Unit,
) {
    var timer by remember { mutableIntStateOf(device.timer.value) }
    var power by remember { mutableIntStateOf(device.power.value) }
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Timer: ")
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "",
                    tint = RevercedPrimary,
                    modifier = Modifier
                        .clickable {
                            timer -= if (timer == 0) 0 else 5
                        }
                )
                Text(text = "$timer")
                Icon(
                    imageVector = Icons.Default.KeyboardArrowUp,
                    contentDescription = "",
                    tint = RevercedPrimary,
                    modifier = Modifier
                        .clickable {
                            timer += 5
                        }
                )
            }
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Power: ")
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "",
                    tint = RevercedPrimary,
                    modifier = Modifier
                        .clickable {
                            power -= if (power == 0) 0 else 50
                        }
                )
                Text(text = "$power")
                Icon(
                    imageVector = Icons.Default.KeyboardArrowUp,
                    contentDescription = "",
                    tint = RevercedPrimary,
                    modifier = Modifier
                        .clickable {
                            power += 50
                        }
                )
            }
        }


    }
    CapsuleButton(
        text = "Apply",
        onClick = {
            onEvent(SettingsEvent.SetTimer(device.id, timer))
            onEvent(SettingsEvent.ChangePower(device.id, power))
            onEvent(SettingsEvent.EditDevice(device.id))
        },
        modifier = Modifier
            .padding(horizontal = padL)
            .fillMaxWidth()
    )
}