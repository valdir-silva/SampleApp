package com.example.valdirssampleapp.sdui

import com.example.valdirssampleapp.networking.data.response.sections.ButtonSectionResponse
import com.example.valdirssampleapp.networking.data.response.sections.TextSectionResponse
import kotlin.reflect.KClass

object SectionTypes {
    val SECTION_TYPES = mapOf<String, KClass<*>>(
        "text" to TextSectionResponse::class,
        "button" to ButtonSectionResponse::class,
    )
}