package com.example.intelligenthomeapp.settings.presentation.components.device_edit

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.intelligenthomeapp.settings.data.device.Device
import com.example.intelligenthomeapp.settings.presentation.components.CapsuleButton
import com.example.intelligenthomeapp.settings.presentation.screens.SettingsEvent
import com.example.intelligenthomeapp.ui.theme.Primary
import com.example.intelligenthomeapp.ui.theme.PrimaryText
import com.example.intelligenthomeapp.ui.theme.RevercedPrimary
import com.example.intelligenthomeapp.ui.theme.RoundedM
import com.example.intelligenthomeapp.ui.theme.SecondaryText
import com.example.intelligenthomeapp.ui.theme.Surface
import com.example.intelligenthomeapp.ui.theme.padL
import com.example.intelligenthomeapp.ui.theme.padS
import kotlin.math.round

@Composable
fun DeviceEditDialogue(
    device: Device,
    onEvent: (SettingsEvent) -> Unit,
    onDismiss: () -> Unit
    ) {
    Dialog(onDismissRequest = { onDismiss() }) {
        Column(
            modifier = Modifier
                .shadow(4.dp, RoundedM)
                .background(Primary, RoundedM)
                .padding(padS)
        ) {
            Row(
                modifier = Modifier
//                        .background(a, RoundedM)
//                        .padding(horizontal = 7.dp)
            ) {
                Text(
                    text = "${device.type} | ",
                    style = MaterialTheme.typography.titleMedium,
                    color = PrimaryText
                )
                Text(
                    text = "${online(device.online)}",
                    style = MaterialTheme.typography.titleMedium,
                    color = PrimaryText,
                )
            }

            Text(
                text = device.id,
                style = MaterialTheme.typography.bodySmall,
                color = SecondaryText
            )
            Spacer(modifier = Modifier.height(padS))

            when (device) {
                is Device.Conditioner -> ConditionerEdit(
                    device = device,
                    onEvent = onEvent,
                )
                is Device.Fridge -> FridgeEdit(
                    device = device,
                    onEvent = onEvent,
                )
                is Device.Kettle -> KettleEdit(
                    device = device,
                    onEvent = onEvent,
                )
                is Device.Luminaire -> Unit
                is Device.Microwave -> MicrowaveEdit(
                    device = device,
                    onEvent = onEvent
                )
                is Device.Vacuum -> Unit
                is Device.Default -> Unit
            }

        }
    }
}

private fun online(online: Boolean): String {
    return if (online) "online" else "offline"
}



@Composable
@Preview(showBackground = true)
fun DeviceEditDialoguePreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Surface)
    ) {
        DeviceEditDialogue(device = Device.Microwave(), {}) {

        }
    }

}