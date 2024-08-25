package com.example.valdirssampleapp.networking.data.response.sections

import com.squareup.moshi.Json

private const val type = "TEXT"

data class TextSectionResponse(
    @Json(name = "text")
    val text: String
): SectionResponse(type)

