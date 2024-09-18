package com.example.intelligenthomeapp.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.core.content.pm.ShortcutInfoCompat.Surface
import com.example.intelligenthomeapp.settings.data.device.Device

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)


val MicrowaveColor = Color(0xFFFFFFE3)
val ConditionerColor = Color(0xFFE2E8FF)
val KettleColor = Color(0xFFFFF1E6)
val FridgeColor = Color(0xFFE6FAFF)
val VacuumColor = Color(0xFFF7F0FF)
val LuminaireColor = Color(0xFFF3FFE4)

val Surface = Color(0xFFF7F7F7)
val Primary = Color(0xFFFCFFFF)
val RevercedPrimary = Color(0xFF383838)
val Secondary  = Color(0xFFE6E6E6)
val DeviceOnline = Color(0xFF7CB342)
val DeviceOffline = Color(0xFFE53935)


val PrimaryText = Color(0xFF242424)
val SecondaryText = Color(0xFF7C7C7C)
val RevercedPrimaryText = Color(0xFFECECEC)



val a = Color(0xFFF7F7F7)
val GradMicrowave = Brush.horizontalGradient(listOf(MicrowaveColor, a, ))
val GradConditioner = Brush.horizontalGradient(listOf(ConditionerColor, a, ))
val GradKettle = Brush.horizontalGradient(listOf(KettleColor, a, ))
val GradFridge = Brush.horizontalGradient(listOf(FridgeColor, a, ))
val GradVacuum = Brush.horizontalGradient(listOf(VacuumColor, a, ))
val GradLuminaire = Brush.horizontalGradient(listOf(LuminaireColor, a, ))
val GradDefault = Brush.horizontalGradient(listOf(Primary, a, ))

val GradPrimary = Brush.verticalGradient(listOf(Surface, Primary, Primary))


