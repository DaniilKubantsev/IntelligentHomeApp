package com.example.intelligenthomeapp.settings.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.intelligenthomeapp.settings.data.repository.DeviceRepositoryImpl
import com.example.intelligenthomeapp.settings.presentation.components.AvailableDeviceView
import com.example.intelligenthomeapp.settings.presentation.components.CapsuleButton
import com.example.intelligenthomeapp.settings.presentation.components.DeviceView
import com.example.intelligenthomeapp.ui.theme.GradPrimary
import com.example.intelligenthomeapp.ui.theme.IntelligentHomeAppTheme
import com.example.intelligenthomeapp.ui.theme.Primary
import com.example.intelligenthomeapp.ui.theme.PrimaryText
import com.example.intelligenthomeapp.ui.theme.RevercedPrimary
import com.example.intelligenthomeapp.ui.theme.RevercedPrimaryText
import com.example.intelligenthomeapp.ui.theme.Secondary
import com.example.intelligenthomeapp.ui.theme.Surface
import com.example.intelligenthomeapp.ui.theme.padM
import com.example.intelligenthomeapp.ui.theme.padS

@Composable
fun SettingsScreen(
    vm: SettingsViewModel = SettingsViewModel()
){
    val state by vm.uiState.collectAsState()
    val padding = 10.dp

    var shown by remember { mutableStateOf(false) }
    
    var title by remember { mutableStateOf("Your devices") }
    title = if (shown) "Available devices" else "Your devices"


    Column(
        modifier = Modifier
            .safeContentPadding()
            .fillMaxSize()
            .background(Surface)
    ) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .background(GradPrimary)
                .padding(padding)
        ){
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge
            )
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(5.dp),
            contentPadding = PaddingValues(0.dp, 5.dp),
            modifier = Modifier
                .fillMaxHeight(0.93f)
                .background(Color.Transparent)
                .padding(horizontal = padS)
        ) {
            val list = if (shown) state.availableDeviceData else state.deviceData
            items(list){  device ->
                if(shown) {
                    AvailableDeviceView(
                        device = device,
                        onEvent = { vm.onEvent(it) }
                    )
                } else {
                    DeviceView(
                        device = device,
                        onEvent = {vm.onEvent(it)},
                        isModifying = state.openedSettingsDeviceID == device.id,
                        isEditing = state.editingDeviceId == device.id
                    )
                }

            }
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                //.padding(padding)
                .background(GradPrimary)
                .clickable(onClick = {}, enabled = false)

        ){
            CapsuleButton(
                text = if (shown) "Back" else "Add device",
                icon = if (shown) Icons.AutoMirrored.Filled.KeyboardArrowLeft else Icons.Default.Add,
                onClick = {
                    shown = !shown
                }
            )


        }

    }

}


@Preview
@Composable
fun SettingsScreenPreview(){
    IntelligentHomeAppTheme {
        SettingsScreen()
    }

}