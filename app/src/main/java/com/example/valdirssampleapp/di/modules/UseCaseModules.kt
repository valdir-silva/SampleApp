package com.example.valdirssampleapp.di.modules

import com.example.valdirssampleapp.domain.getHome.GetHomeUseCase
import org.koin.dsl.module

val useCaseModule = module {

    single { GetHomeUseCase(get()) }
}
