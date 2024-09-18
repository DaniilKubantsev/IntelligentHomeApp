package com.example.intelligenthomeapp.settings.presentation.screens

sealed class SettingsEvent {
    data class OpenSettings(val id: String) : SettingsEvent()
    data class ToggleDevice(val id: String) : SettingsEvent()
    data class DeleteDevice(val id: String) : SettingsEvent()
    data class EditDevice(val id: String) : SettingsEvent()
    data class ChangeTemperature(val id: String, val t: Float) : SettingsEvent()
    data class SetTimer(val id: String, val seconds: Int) : SettingsEvent()
    data class ChangePower(val id: String, val wt: Int) : SettingsEvent()
}