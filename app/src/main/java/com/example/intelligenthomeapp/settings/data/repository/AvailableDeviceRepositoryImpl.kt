package com.example.intelligenthomeapp.settings.data.repository

import com.example.intelligenthomeapp.settings.data.data_source.availableDevicesData
import com.example.intelligenthomeapp.settings.data.device.Device
import com.example.intelligenthomeapp.settings.domain.repository.DeviceRepository

class AvailableDeviceRepositoryImpl : DeviceRepository {
    override fun getDeviceList(): List<Device> {
        return availableDevicesData
    }

    override fun updateDeviceList(id: String, device: Device) {
        TODO("Not yet implemented")
    }
}