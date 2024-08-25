package com.example.valdirssampleapp.networking.data.response.sections

import com.squareup.moshi.Json

sealed class SectionResponse(
    @Json(name = "type")
    val type: String
)