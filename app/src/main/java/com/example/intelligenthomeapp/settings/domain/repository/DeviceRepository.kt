package com.example.intelligenthomeapp.settings.domain.repository

import com.example.intelligenthomeapp.settings.data.device.Device
import com.example.intelligenthomeapp.settings.data.device.DeviceType
import com.example.intelligenthomeapp.settings.data.repository.DeviceRepositoryImpl

interface DeviceRepository {
    fun getDeviceList(): List<Device>
    fun updateDeviceList(id: String, device: Device)
}
