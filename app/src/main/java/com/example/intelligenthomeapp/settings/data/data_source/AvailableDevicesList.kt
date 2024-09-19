package com.example.intelligenthomeapp.settings.data.data_source

import com.example.intelligenthomeapp.settings.data.device.Device
import java.util.UUID

var availableDevicesData = mutableListOf(
    Device.Vacuum(
        id = UUID.randomUUID().toString()
    ),
    Device.Conditioner(
        id = UUID.randomUUID().toString()
    ),
)