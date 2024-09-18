package com.example.intelligenthomeapp.settings.data.repository

import com.example.intelligenthomeapp.data_source.devicesData
import com.example.intelligenthomeapp.settings.data.device.Device
import com.example.intelligenthomeapp.settings.domain.repository.DeviceRepository

class DeviceRepositoryImpl : DeviceRepository {
    override fun getDeviceList(): List<Device> {
        return devicesData
    }

    override fun updateDeviceList(id: String, device: Device) {
        devicesData.find{ it.id == id }.apply { device }
    }
}
