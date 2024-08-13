package com.example.intelligenthomeapp.domain.entities.device

data class Default(
    override val type: DeviceType = DeviceType.Default,
    override val online: Boolean = true,
    override val id: UInt = 0u,
) : Device
