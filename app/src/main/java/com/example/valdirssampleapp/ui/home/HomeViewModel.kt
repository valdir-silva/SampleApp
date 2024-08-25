package com.example.valdirssampleapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valdirssampleapp.domain.getHome.GetHomeUseCase
import com.example.valdirssampleapp.domain.models.SectionsModel
import com.example.valdirssampleapp.domain.onResultFailure
import com.example.valdirssampleapp.domain.onResultSuccess
import com.example.valdirssampleapp.utils.toLiveData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

// TODO criar useCase que chama o repository e colocar a dependencia do useCase aqui
class HomeViewModel(private val getHomeUseCase: GetHomeUseCase) : ViewModel() {

    private val _sectionsList = MutableLiveData<SectionsModel>()
    val sectionsList = _sectionsList.toLiveData()

    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            getHomeUseCase(Unit)
                .onResultSuccess {
                    _isLoading.value = false
                    _sectionsList.value = it
                }
                .onResultFailure {
                    _isLoading.value = false
                    // TODO tratar erro
                }
        }
    }
}
