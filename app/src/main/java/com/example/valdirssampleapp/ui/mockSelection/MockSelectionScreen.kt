package com.example.valdirssampleapp.ui.mockSelection

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.valdirssampleapp.networking.ApiService
import org.koin.androidx.compose.koinViewModel

@Composable
fun MockSelectionScreen(
    viewModel: MockViewModel = koinViewModel(),
    navController: NavController,
    apiService: ApiService,
) {
    val selectedMock = viewModel.selectedMock.value

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
        apiService.recreateRetroMock(context = LocalContext.current, jsonPath = selectedMock)

        Button(onClick = { navController.navigate("home") }) {
            Text(text = "Navigate to Home Screen")
        }
    }
}