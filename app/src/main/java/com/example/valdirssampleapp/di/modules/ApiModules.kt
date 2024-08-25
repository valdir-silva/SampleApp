package com.example.valdirssampleapp.di.modules

import com.example.valdirssampleapp.networking.ApiService
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val apiModule = module {

    single { ApiService(androidContext()) }
}
