package com.example.valdirssampleapp.networking.data.response.sections

private const val type = "BUTTON"

data class ButtonSectionResponse(
    val content: String // TODO mudar pra text
): SectionResponse(type)