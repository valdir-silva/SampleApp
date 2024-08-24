package com.example.valdirssampleapp.ui.mockSelection

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.valdirssampleapp.networking.ApiService

@Composable
fun MockSelectionScreen(
    viewModel: MockViewModel = viewModel(),
    navController: NavController,
) {
    val selectedMock = viewModel.selectedMock.value

    var goToHome by remember { mutableStateOf(false) }

    Column {
        Text("Selecione o Mock:")
        Row {
            Button(onClick = { viewModel.selectMock("homeSections.json") }) {
                Text("Home")
            }
            Button(onClick = { viewModel.selectMock("homeSections2.json") }) {
                Text("Home 2")
            }
        }
        Text("Mock selecionado: $selectedMock")
        ApiService.recreateRetroMock(context = LocalContext.current, jsonPath = selectedMock)

        Button(onClick = { navController.navigate("user_list") }) {
            Text(text = "Navigate to Home Screen")
        }
    }
}