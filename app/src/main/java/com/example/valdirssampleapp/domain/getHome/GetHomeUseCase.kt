package com.example.valdirssampleapp.domain.getHome

import com.example.valdirssampleapp.domain.SampleUseCase
import com.example.valdirssampleapp.domain.models.SectionsModel
import com.example.valdirssampleapp.repository.SampleRepository

class GetHomeUseCase(private val repository: SampleRepository) :
    SampleUseCase<SectionsModel, Unit>() {

    override suspend fun execute(parameters: Unit) = repository.getSections()
}
