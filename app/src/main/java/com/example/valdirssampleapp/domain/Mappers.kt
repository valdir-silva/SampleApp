package com.example.valdirssampleapp.domain

import com.example.valdirssampleapp.domain.models.ButtonSectionModel
import com.example.valdirssampleapp.domain.models.SectionModel
import com.example.valdirssampleapp.domain.models.SectionsModel
import com.example.valdirssampleapp.domain.models.TextSectionModel
import com.example.valdirssampleapp.networking.data.response.sections.ButtonSectionResponse
import com.example.valdirssampleapp.networking.data.response.sections.SectionResponse
import com.example.valdirssampleapp.networking.data.response.sections.SectionsResponse
import com.example.valdirssampleapp.networking.data.response.sections.TextSectionResponse

// TODO melhorar códogo para criar uma lista de models e ter como passar para o koin usar em outros modulos
fun SectionsResponse.toModel(): SectionsModel =
    SectionsModel(
        title = title,
        sections = sections.toModel()
    )

fun List<SectionResponse>.toModel(): List<SectionModel> = map { it.toModel() }
fun SectionResponse.toModel(): SectionModel = when (this) {
    is ButtonSectionResponse -> toModel()
    is TextSectionResponse -> toModel()
}

fun ButtonSectionResponse.toModel(): ButtonSectionModel = ButtonSectionModel(content)
fun TextSectionResponse.toModel(): TextSectionModel = TextSectionModel(text)