package com.example.valdirssampleapp.networking.data.response.sections

private const val type = "TEXT"

data class TextSectionResponse(
    val text: String
): SectionResponse(type)

