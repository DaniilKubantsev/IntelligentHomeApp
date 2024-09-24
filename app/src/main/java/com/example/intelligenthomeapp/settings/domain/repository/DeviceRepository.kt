package com.example.intelligenthomeapp.settings.domain.repository

import com.example.intelligenthomeapp.settings.data.device.Device
import com.example.intelligenthomeapp.settings.data.repository.DeviceRepositoryImpl

interface DeviceRepository {
    fun add(device: Device)
    fun get(): List<Device>
    fun update(id: String, device: Device)
    fun delete(id: String)
}
