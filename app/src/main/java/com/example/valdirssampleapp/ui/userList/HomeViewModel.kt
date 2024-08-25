package com.example.valdirssampleapp.ui.userList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valdirssampleapp.networking.ApiSectionsResults
import com.example.valdirssampleapp.networking.data.response.sections.SectionsResponse
import com.example.valdirssampleapp.repository.SampleRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

// TODO criar useCase que chama o repository e colocar a dependencia do useCase aqui
open class HomeViewModel(private val repository: SampleRepository) : ViewModel() {

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
            repository.getSections { result: ApiSectionsResults ->
                when (result) {
                    is ApiSectionsResults.Success -> {
                        _sectionsList.value = result.sectionsList
                        _isLoading.value = false
                    }

                    is ApiSectionsResults.ApiError -> {
                        // Handle API error
                        println("Error: ${result.statusCode}")
                        _isLoading.value = false
                    }

                    is ApiSectionsResults.ServerError -> {
                        // Handle network error
                        println("Network error")
                        _isLoading.value = false
                    }
                }

            }
        }
    }

}