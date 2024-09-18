package com.example.intelligenthomeapp.settings.presentation.screens

import com.example.intelligenthomeapp.settings.data.device.Device
import java.lang.Error

data class SettingsState(
    val deviceData: List<Device> = listOf(),
    val openedSettingsDeviceID: String = "Device.Default()",
    val editingDeviceId: String = "Device.Default()",
    val error: String? = null,
)