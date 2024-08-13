package com.example.intelligenthomeapp.domain.entities.device

data class Kettle(
    override val type: DeviceType = DeviceType.Kettle,
    override val id: UInt,
    override val online: Boolean,
    val currentTemperature: Float,
    val targetTemperature: Float,
): Device
