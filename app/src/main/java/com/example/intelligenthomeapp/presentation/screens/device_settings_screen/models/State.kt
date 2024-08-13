package com.example.intelligenthomeapp.presentation.screens.device_settings_screen.models

import com.example.intelligenthomeapp.domain.entities.device.Default
import com.example.intelligenthomeapp.domain.entities.device.Device

data class DeviceSettingsState(
    val deviceList: List<Device> = listOf(),
    val configurableDevice: Device = Default()
)