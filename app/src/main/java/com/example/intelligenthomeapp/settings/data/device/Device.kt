package com.example.intelligenthomeapp.settings.data.device

import androidx.annotation.IntRange
import java.util.UUID


sealed interface DeviceFeature {
    data class Temperature(val value: Float) : DeviceFeature
    data class Timer(val value: Int) : DeviceFeature
    data class Pressure(val value: Float) : DeviceFeature
    data class Power(val value: Int) : DeviceFeature
    data class Charge(@IntRange(0, 100) val value: Int) : DeviceFeature
    data object None
}

sealed class Device(
    open val type: String,
    open val online: Boolean,
    open val id: String = UUID.randomUUID().toString(),
) {
    data class Conditioner(
        override val type: String = "Conditioner",
        override val online: Boolean = false,
        override val id: String = UUID.randomUUID().toString(),
        val currentTemperature: DeviceFeature.Temperature = DeviceFeature.Temperature(23f),
        val targetTemperature: DeviceFeature.Temperature = DeviceFeature.Temperature(23f)
    ) : Device(type, online, id)

    data class Fridge(
        override val type: String = "Fridge",
        override val online: Boolean = false,
        override val id: String = UUID.randomUUID().toString(),
        val currentTemperature: DeviceFeature.Temperature = DeviceFeature.Temperature(23f),
        val targetTemperature: DeviceFeature.Temperature = DeviceFeature.Temperature(23f)
    ) : Device(type, online, id)

    data class Kettle(
        override val type: String = "Kettle",
        override val online: Boolean = false,
        override val id: String = UUID.randomUUID().toString(),
        val currentTemperature: DeviceFeature.Temperature = DeviceFeature.Temperature(40f),
        val targetTemperature: DeviceFeature.Temperature = DeviceFeature.Temperature(35f),
        val waterPressure: DeviceFeature.Pressure = DeviceFeature.Pressure(100f)
    ) : Device(type, online, id)

    data class Luminaire(
        override val type: String = "Luminaire",
        override val online: Boolean = false,
        override val id: String = UUID.randomUUID().toString(),
    ) : Device(type, online, id)

    data class Microwave(
        override val type: String = "Microwave",
        override val online: Boolean = false,
        override val id: String = UUID.randomUUID().toString(),
        val timer: DeviceFeature.Timer = DeviceFeature.Timer(0),
        val power: DeviceFeature.Power = DeviceFeature.Power(400)
    ) : Device(type, online, id)

    data class Vacuum(
        override val type: String = "Vacuum",
        override val online: Boolean = false,
        override val id: String = UUID.randomUUID().toString(),
        val charge: DeviceFeature.Charge = DeviceFeature.Charge(100)
    ) : Device(type, online, id)

    data class Default(
        override val type: String = "Default",
        override val online: Boolean = true,
        override val id: String = UUID.randomUUID().toString(),
    ) : Device(type, online, id)
}