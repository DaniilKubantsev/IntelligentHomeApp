package com.example.intelligenthomeapp.domain.entities.device

data class Conditioner(
    override val type: DeviceType = DeviceType.Сonditioner,
    override val id: UInt,
    override val online: Boolean,
    val currentTemperature: Float,
): Device
