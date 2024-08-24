package com.example.valdirssampleapp.ui.mockSelection

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MockViewModel : ViewModel() {

    private val _selectedMock = mutableStateOf("homeSections.json")
    val selectedMock: State<String> = _selectedMock

    fun selectMock(mock: String) {
        _selectedMock.value = mock
    }

    // Função para obter o Service com o Mock correto
//    fun getService(): Service {
//        val mockFileName = selectedMock.value
//        return when (mockFileName) {
//            "events.json" -> {
//                // Retorna o Service com o Mock para events.json
//            }
//            "checkin.json" -> {
//                // Retorna o Service com o Mock para checkin.json
//            }
//            "homeSections.json" -> {
//                // Retorna o Service com o Mock para homeSections.json
//            }
//            else -> {
//                // Retorna um Service padrão ou lança uma exceção
//            }
//        }
//    }
}