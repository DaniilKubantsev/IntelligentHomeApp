package com.example.intelligenthomeapp.settings.presentation.components

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAbsoluteAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.intelligenthomeapp.R
import com.example.intelligenthomeapp.settings.data.device.Device
import com.example.intelligenthomeapp.settings.presentation.components.device_edit.DeviceEditDialogue
import com.example.intelligenthomeapp.settings.presentation.components.device_info.ConditionerInfo
import com.example.intelligenthomeapp.settings.presentation.components.device_info.FridgeInfo
import com.example.intelligenthomeapp.settings.presentation.components.device_info.KettleInfo
import com.example.intelligenthomeapp.settings.presentation.components.device_info.MicrowaveInfo
import com.example.intelligenthomeapp.settings.presentation.components.device_info.VacuumInfo
import com.example.intelligenthomeapp.settings.presentation.screens.SettingsEvent
import com.example.intelligenthomeapp.ui.theme.DeviceOffline
import com.example.intelligenthomeapp.ui.theme.DeviceOnline
import com.example.intelligenthomeapp.ui.theme.GradConditioner
import com.example.intelligenthomeapp.ui.theme.GradDefault
import com.example.intelligenthomeapp.ui.theme.GradFridge
import com.example.intelligenthomeapp.ui.theme.GradKettle
import com.example.intelligenthomeapp.ui.theme.GradLuminaire
import com.example.intelligenthomeapp.ui.theme.GradMicrowave
import com.example.intelligenthomeapp.ui.theme.GradVacuum
import com.example.intelligenthomeapp.ui.theme.IntelligentHomeAppTheme
import com.example.intelligenthomeapp.ui.theme.KettleColor
import com.example.intelligenthomeapp.ui.theme.Primary
import com.example.intelligenthomeapp.ui.theme.PrimaryText
import com.example.intelligenthomeapp.ui.theme.RevercedPrimary
import com.example.intelligenthomeapp.ui.theme.RevercedPrimaryText
import com.example.intelligenthomeapp.ui.theme.RoundedL
import com.example.intelligenthomeapp.ui.theme.RoundedM
import com.example.intelligenthomeapp.ui.theme.Secondary
import com.example.intelligenthomeapp.ui.theme.SecondaryText
import com.example.intelligenthomeapp.ui.theme.a
import com.example.intelligenthomeapp.ui.theme.padM
import com.example.intelligenthomeapp.ui.theme.padS

@Composable
fun DeviceView(
    device: Device,
    onEvent: (SettingsEvent) -> Unit,
    isModifying: Boolean,
    isEditing: Boolean,
) {
    val shape = RoundedCornerShape(20.dp)
    val context = LocalContext.current



    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Secondary, shape = shape)
    ) {
        if (isEditing) {
            DeviceEditDialogue(
                device = device,
                onEvent = onEvent,
                onDismiss = { onEvent(SettingsEvent.EditDevice(device.id)) }
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,

            modifier = Modifier
                .fillMaxWidth()
                .shadow(12.dp, shape = RoundedM)
                .background(Primary, shape = RoundedM)
                .padding(padM)
                .clickable {
                    onEvent(SettingsEvent.OpenSettings(device.id))
                }
        ) {
            DeviceIcon(
                painter = devicePainter(device = device),
                online = device.online,
                onlineColor = DeviceOnline,
                offlineColor = DeviceOffline,
                onClick = { onEvent(SettingsEvent.ToggleDevice(device.id)) }
            )

            Spacer(modifier = Modifier.width(padM))
            Column {
                Row(
                    modifier = Modifier
//                        .background(a, RoundedM)
//                        .padding(horizontal = 7.dp)
                ) {
                    Text(
                        text = "${device.type} |",
                        style = MaterialTheme.typography.titleMedium,
                        color = PrimaryText
                    )
                    Text(
                        text = " ${online(device.online)}",
                        style = MaterialTheme.typography.titleMedium,
                        color = PrimaryText,
                        modifier = Modifier
                            .clickable {
                                onEvent(SettingsEvent.ToggleDevice(device.id))
                            }
                    )
                }

                Text(
                    text = device.id,
                    style = MaterialTheme.typography.bodySmall,
                    color = SecondaryText
                )
            }
        }
        AnimatedVisibility(visible = isModifying) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(padS)
                    .background(Primary, RoundedL)
                    .padding(horizontal = padM, vertical = padS)
            ) {

                when (device) {
                    is Device.Fridge -> FridgeInfo(device = device)
                    is Device.Conditioner -> ConditionerInfo(device = device)
                    is Device.Kettle -> KettleInfo(device = device)
                    is Device.Vacuum -> VacuumInfo(device = device)
                    is Device.Microwave -> MicrowaveInfo(device = device)
                    is Device.Luminaire -> Unit
                    is Device.Default -> Unit
                }


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "",
                        tint = RevercedPrimaryText,
                        modifier = Modifier
                            .shadow(4.dp, CircleShape)
                            .background(RevercedPrimary, CircleShape)
                            .padding(5.dp)
                            .clickable {
                                onEvent(SettingsEvent.DeleteDevice(device.id))
                                Toast
                                    .makeText(
                                        context,
                                        "deleted: ${device.type}\n${device.id}\ndeleted",
                                        Toast.LENGTH_SHORT
                                    )
                                    .show()
                            }
                    )
                    Spacer(modifier = Modifier.width(padS))
                    if (
                        device is Device.Fridge
                        || device is Device.Conditioner
                        || device is Device.Kettle
                        || device is Device.Microwave
                    )
                        Icon(
                            imageVector = Icons.Default.Create,
                            contentDescription = "",
                            tint = RevercedPrimaryText,
                            modifier = Modifier
                                .shadow(4.dp, CircleShape)
                                .background(RevercedPrimary, CircleShape)
                                .padding(5.dp)
                                .clickable {
                                    onEvent(SettingsEvent.EditDevice(device.id))
                                }
                        )
                }
            }
        }
    }
}


private fun online(online: Boolean): String {
    return if (online) "online" else "offline"
}

private fun Modifier.modifyingHeight(
    isModifying: Boolean
): Modifier {
    return this then if (isModifying) Modifier.height(400.dp)
    else Modifier
}


@Composable
private fun backgroundGrad(
    device: Device
): Brush = when (device) {
    is Device.Conditioner -> GradConditioner
    is Device.Fridge -> GradFridge
    is Device.Kettle -> GradKettle
    is Device.Luminaire -> GradLuminaire
    is Device.Microwave -> GradMicrowave
    is Device.Vacuum -> GradVacuum
    is Device.Default -> GradDefault
}

@Composable
private fun devicePainter(
    device: Device
): Painter = when (device) {
    is Device.Conditioner -> painterResource(id = R.drawable.icons8_air_conditioner_96)
    is Device.Fridge -> painterResource(id = R.drawable.icons8_fridge_96)
    is Device.Kettle -> painterResource(id = R.drawable.icons8_water_heater_96)
    is Device.Luminaire -> painterResource(id = R.drawable.icons8_light_96)
    is Device.Microwave -> painterResource(id = R.drawable.icons8_microwave_96)
    is Device.Vacuum -> painterResource(id = R.drawable.icons8_vacuum_96)
    is Device.Default -> painterResource(id = R.drawable.icons8_air_conditioner_96)
}

@Preview
@Composable
fun DeviceViewPreview() {
    IntelligentHomeAppTheme {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            DeviceView(
                device = Device.Kettle(),
                onEvent = {},
                isModifying = true,
                isEditing = true,
            )
        }

    }

}
