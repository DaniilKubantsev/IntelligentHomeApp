package com.example.intelligenthomeapp.domain.entities.device

interface Device{
    val type: DeviceType
    val online: Boolean
    val id: UInt
}