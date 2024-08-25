package com.example.valdirssampleapp.ui.userList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valdirssampleapp.domain.getHome.GetHomeUseCase
import com.example.valdirssampleapp.domain.models.SectionsModel
import com.example.valdirssampleapp.domain.onResultFailure
import com.example.valdirssampleapp.domain.onResultSuccess
import com.example.valdirssampleapp.networking.data.response.sections.SectionsResponse
import com.example.valdirssampleapp.repository.SampleRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

// TODO criar useCase que chama o repository e colocar a dependencia do useCase aqui
class HomeViewModel(private val getHomeUseCase: GetHomeUseCase) : ViewModel() {

    private val _sectionsList = MutableLiveData<SectionsResponse>()
    open val sectionsList: LiveData<SectionsResponse>
        get() = _sectionsList

    private val _isLoading = MutableStateFlow(true)
    open val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

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
