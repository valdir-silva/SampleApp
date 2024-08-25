package com.example.valdirssampleapp.di.modules

import com.example.valdirssampleapp.repository.SampleRepository
import com.example.valdirssampleapp.repository.SampleRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    single<SampleRepository> { SampleRepositoryImpl(get()) }
}
