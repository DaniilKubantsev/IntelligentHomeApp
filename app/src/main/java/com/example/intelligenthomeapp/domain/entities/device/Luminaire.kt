package com.example.intelligenthomeapp.domain.entities.device

data class Luminaire(
    override val type: DeviceType = DeviceType.Luminaire,
    override val online: Boolean,
    override val id: UInt
) : Device
