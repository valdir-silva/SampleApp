package com.example.valdirssampleapp.networking.data.response.sections

import com.squareup.moshi.Json

data class SectionsResponse(
    @Json(name = "title")
    val title: String,
    @Json(name = "sections")
    val sections: List<SectionResponse>
)