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
}