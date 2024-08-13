package com.example.intelligenthomeapp.domain.entities.device

data class Microwave(
    override val type: DeviceType = DeviceType.Microwave,
    override val online: Boolean,
    override val id: UInt,
    val timer: UInt,
) : Device
