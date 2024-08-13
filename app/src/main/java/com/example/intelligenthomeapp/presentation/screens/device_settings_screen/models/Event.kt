package com.example.intelligenthomeapp.presentation.screens.device_settings_screen.models

sealed class DeviceSettingsEvent {
    data class OpenAdvancedSettings(val deviceId: UInt) : DeviceSettingsEvent()
    data class DeleteDevice(val deviceId: UInt) : DeviceSettingsEvent()
    object AddDevice : DeviceSettingsEvent()
}