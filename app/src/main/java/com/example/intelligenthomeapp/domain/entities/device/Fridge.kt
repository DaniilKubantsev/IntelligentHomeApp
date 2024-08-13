package com.example.intelligenthomeapp.domain.entities.device


data class Fridge(
    override val type: DeviceType = DeviceType.Fridge,
    override val id: UInt,
    override val online: Boolean,
    val currentTemperature: Float,
): Device
