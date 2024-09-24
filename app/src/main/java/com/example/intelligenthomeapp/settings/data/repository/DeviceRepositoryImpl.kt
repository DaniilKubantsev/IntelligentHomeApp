package com.example.intelligenthomeapp.settings.data.repository

import com.example.intelligenthomeapp.settings.data.data_source.devicesData
import com.example.intelligenthomeapp.settings.data.device.Device
import com.example.intelligenthomeapp.settings.domain.repository.DeviceRepository
import com.example.intelligenthomeapp.utils.myLog

class DeviceRepositoryImpl : DeviceRepository {
    override fun add(device: Device) {
        devicesData.add(device)
    }

    //костыль, который не знаю, как пофиксить
    //для обновления ui нужно, чтобы поменялась ссылка в uiState,
    //для чего и используется map
    override fun get(): List<Device> {
        return devicesData.map { it }
    }

    override fun update(id: String, device: Device) {
        val index = devicesData.indexOfFirst{ it.id == id }
        devicesData[index] = device
    }

    override fun delete(id: String) {
        val device = devicesData.find { it.id == id }
        devicesData.remove(device)
    }
}
