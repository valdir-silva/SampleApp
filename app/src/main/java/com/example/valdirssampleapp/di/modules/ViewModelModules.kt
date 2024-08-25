package com.example.valdirssampleapp.di.modules

import com.example.valdirssampleapp.ui.mockSelection.MockViewModel
import com.example.valdirssampleapp.ui.userList.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { HomeViewModel(get()) }
    viewModel { MockViewModel() }
}
