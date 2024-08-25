package com.example.valdirssampleapp.networking.data.response.sections

import com.squareup.moshi.Json

private const val type = "BUTTON"

data class ButtonSectionResponse(
    @Json(name = "content")
    val content: String // TODO mudar pra text
) : SectionResponse(type)