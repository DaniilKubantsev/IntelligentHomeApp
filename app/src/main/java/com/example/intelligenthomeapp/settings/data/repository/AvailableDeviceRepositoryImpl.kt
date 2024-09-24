package com.example.intelligenthomeapp.settings.data.repository

import com.example.intelligenthomeapp.settings.data.data_source.availableDevicesData
import com.example.intelligenthomeapp.settings.data.device.Device
import com.example.intelligenthomeapp.settings.domain.repository.DeviceRepository

class AvailableDeviceRepositoryImpl : DeviceRepository {
    override fun add(device: Device) {
        availableDevicesData.add(device)
    }

    //костыль, который не знаю, как пофиксить
    //для обновления ui нужно, чтобы поменялась ссылка в uiState,
    //для чего и используется map
    override fun get(): List<Device> {
        return availableDevicesData.map { it }
    }

    override fun update(id: String, device: Device) {
        val index = availableDevicesData.indexOfFirst{ it.id == id }
        availableDevicesData[index] = device
    }

    override fun delete(id: String) {
        val device = availableDevicesData.find { it.id == id }
        availableDevicesData.remove(device)
    }
}