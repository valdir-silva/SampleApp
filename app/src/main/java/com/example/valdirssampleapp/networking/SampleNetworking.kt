package com.example.valdirssampleapp.networking

import com.example.valdirssampleapp.networking.data.response.EventResponse
import com.example.valdirssampleapp.networking.data.response.sections.SectionsResponse
import retrofit2.Response
import retrofit2.http.Field

interface SampleNetworking {

    suspend fun getEvents(): Response<EventResponse>

    suspend fun checkIn(
        @Field("eventId") eventId: String? = null,
        @Field("name") name: String,
        @Field("email") email: String
    ): Response<Map<String, String>>

    suspend fun getSections(): Response<SectionsResponse>
}