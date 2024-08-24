package com.example.valdirssampleapp.ui.userList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valdirssampleapp.networking.ApiSectionsResults
import com.example.valdirssampleapp.networking.data.response.sections.SectionsResponse
import com.example.valdirssampleapp.repository.EventsRepositoryImpl
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    private val dataSource = EventsRepositoryImpl()

    private val _sectionsList = MutableLiveData<SectionsResponse>()
    val sectionsList: LiveData<SectionsResponse>
        get() = _sectionsList

    init {
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch {
            dataSource.getSections { result: ApiSectionsResults ->
                when (result) {
                    is ApiSectionsResults.Success -> {
                        _sectionsList.value = result.sectionsList
                    }

                    is ApiSectionsResults.ApiError -> {
                        // Handle API error
                        println("Error: ${result.statusCode}")
                    }

                    is ApiSectionsResults.ServerError -> {
                        // Handle network error
                        println("Network error")
                    }
                }

            }
        }
    }

}