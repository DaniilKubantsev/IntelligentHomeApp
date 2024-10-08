package com.example.intelligenthomeapp.settings.data.data_source

import com.example.intelligenthomeapp.settings.data.device.Device
import java.util.UUID

val devicesData = mutableListOf(
    Device.Vacuum(
        online = true,
        id = UUID.randomUUID().toString()
    ),
    Device.Microwave(
        online = false,
        id = UUID.randomUUID().toString()
    ),
//    Device.Luminaire(
//        online = true,
//        id = UUID.randomUUID().toString()
//    ),
//    Device.Kettle(
//        id = UUID.randomUUID().toString()
//    ),
//    Device.Fridge(
//        id = UUID.randomUUID().toString()
//    ),
//    Device.Conditioner(
//        id = UUID.randomUUID().toString()
//    ),
//    Device.Luminaire(
//        online = true,
//        id = UUID.randomUUID().toString()
//    ),
//
//    Device.Vacuum(
//        online = true,
//        id = UUID.randomUUID().toString()
//    ),
//    Device.Microwave(
//        online = false,
//        id = UUID.randomUUID().toString()
//    ),
//    Device.Luminaire(
//        online = true,
//        id = UUID.randomUUID().toString()
//    ),
//    Device.Luminaire(
//        online = true,
//        id = UUID.randomUUID().toString()
//    ),
//    Device.Kettle(
//        id = UUID.randomUUID().toString()
//    ),
//
//    Device.Microwave(
//        online = false,
//        id = UUID.randomUUID().toString()
//    ),
//    Device.Luminaire(
//        online = true,
//        id = UUID.randomUUID().toString()
//    ),
)