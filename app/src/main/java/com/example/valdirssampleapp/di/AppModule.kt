package com.example.valdirssampleapp.di

import com.example.valdirssampleapp.di.modules.apiModule
import com.example.valdirssampleapp.di.modules.repositoryModule
import com.example.valdirssampleapp.di.modules.useCaseModule
import com.example.valdirssampleapp.di.modules.viewModelModule

val appModules = listOf(
    apiModule,
    repositoryModule,
    viewModelModule,
    useCaseModule
)