package com.example.intelligenthomeapp.settings.presentation.screens

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.intelligenthomeapp.settings.data.data_source.devicesData
import com.example.intelligenthomeapp.settings.data.device.Device
import com.example.intelligenthomeapp.settings.data.device.DeviceFeature
import com.example.intelligenthomeapp.settings.data.repository.AvailableDeviceRepositoryImpl
import com.example.intelligenthomeapp.settings.data.repository.DeviceRepositoryImpl
import com.example.intelligenthomeapp.settings.domain.repository.DeviceRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.buffer

class SettingsViewModel(
    private val deviceRepository: DeviceRepository = DeviceRepositoryImpl(),
    private val availableDeviceRepository: DeviceRepository = AvailableDeviceRepositoryImpl()
): ViewModel() {
    private val _uiState = MutableStateFlow(SettingsState())
    val uiState = _uiState.asStateFlow()

    init {
       _uiState.value = _uiState.value.copy(
           availableDeviceData = availableDeviceRepository.get(),
           deviceData = deviceRepository.get()
       )
    }

    fun onEvent(event: SettingsEvent) = when(event){
        is SettingsEvent.OpenSettings -> openSettings(event.id)
        is SettingsEvent.ToggleDevice -> toggleDevice(event.id)
        is SettingsEvent.DeleteDevice -> deleteDevice(event.id)
        is SettingsEvent.ChangeTemperature -> changeTemperature(event.id, event.t)
        is SettingsEvent.SetTimer -> setTimer(event.id, event.seconds)
        is SettingsEvent.ChangePower -> changePower(event.id, event.wt)
        is SettingsEvent.EditDevice -> editDevice(event.id)
        is SettingsEvent.AddDevice -> addDevice(event.id)
        is SettingsEvent.ShowAvailableDevices -> showAvailableDevices()
    }

    private fun addDevice(
        id: String
    ) {
        val newDevice = _uiState.value.availableDeviceData.find { it.id == id }!!
        availableDeviceRepository.delete(id)
        deviceRepository.add(newDevice)
        _uiState.value = _uiState.value.copy(
            deviceData = deviceRepository.get(),
            availableDeviceData = availableDeviceRepository.get()
        )
    }

    private fun showAvailableDevices() {
        val a = _uiState.value.availableDeviceShown
        _uiState.value = _uiState.value.copy(
            availableDeviceShown = !a
        )
    }

    private fun changePower(id: String, wt: Int) {
        val device = _uiState.value.deviceData.find { it.id ==id }!!
        val newDevice = when (device) {
            is Device.Microwave -> device.copy(
                power = DeviceFeature.Power(wt)
            )
            else -> device
        }

        deviceRepository.update(id, newDevice)

        _uiState.value = _uiState.value.copy(
            deviceData = deviceRepository.get()
        )
    }

    private fun setTimer(id: String, seconds: Int) {
        val device = _uiState.value.deviceData.find { it.id ==id }!!
        val newDevice = when (device) {
            is Device.Microwave -> device.copy(
                timer = DeviceFeature.Timer(seconds)
            )
            else -> device
        }

        deviceRepository.update(id, newDevice)

        _uiState.value = _uiState.value.copy(
            deviceData = deviceRepository.get()
        )
    }

    private fun changeTemperature(id: String, temp: Float) {
        val device = _uiState.value.deviceData.find { it.id ==id }!!
        val newDevice: Device = when (device) {
            is Device.Conditioner -> device.copy(targetTemperature = DeviceFeature.Temperature(temp))
            is Device.Fridge -> device.copy(targetTemperature = DeviceFeature.Temperature(temp))
            is Device.Kettle -> device.copy(targetTemperature = DeviceFeature.Temperature(temp))
            else -> device
        }

        deviceRepository.update(id, newDevice)

        _uiState.value = _uiState.value.copy(
            deviceData = deviceRepository.get()
        )

    }

    private fun toggleDevice(id: String) {
        val device = _uiState.value.deviceData.find { it.id ==id }!!
        val newDevice = when (device) {
            is Device.Conditioner -> device.copy(online = !device.online)
            is Device.Fridge -> device.copy(online = !device.online)
            is Device.Kettle -> device.copy(online = !device.online)
            is Device.Luminaire -> device.copy(online = !device.online)
            is Device.Microwave -> device.copy(online = !device.online)
            is Device.Vacuum -> device.copy(online = !device.online)
            is Device.Default -> device.copy(online = !device.online)
        }

        deviceRepository.update(id, newDevice)

        _uiState.value = _uiState.value.copy(
            deviceData = deviceRepository.get()
        )
    }

    private fun deleteDevice(id: String) {
        val newDevice = _uiState.value.deviceData.find { it.id == id }!!
        deviceRepository.delete(id)
        availableDeviceRepository.add(newDevice)
        _uiState.value = _uiState.value.copy(
            deviceData = deviceRepository.get(),
            availableDeviceData = availableDeviceRepository.get()
        )
    }

    private fun editDevice(id: String) {

        if (uiState.value.editingDeviceId == id) {
            _uiState.value = _uiState.value.copy(
                editingDeviceId = ""
            )
        } else {
            _uiState.value = _uiState.value.copy(
                editingDeviceId = id
            )
        }
    }

    private fun openSettings(id: String) {
        if (uiState.value.openedSettingsDeviceID == id) {
            _uiState.value = _uiState.value.copy(
                openedSettingsDeviceID = ""
            )
        } else {
            _uiState.value = _uiState.value.copy(
                openedSettingsDeviceID = id
            )
        }
    }
}