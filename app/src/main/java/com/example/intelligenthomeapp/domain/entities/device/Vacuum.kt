package com.example.intelligenthomeapp.domain.entities.device

data class Vacuum(
    override val type: DeviceType = DeviceType.Vacuum,
    override val online: Boolean,
    override val id: UInt
): Device
