package com.example.valdirssampleapp.networking

import com.example.valdirssampleapp.networking.data.response.EventResponse
import com.example.valdirssampleapp.networking.data.response.sections.SectionsResponse
import retrofit2.Response
import retrofit2.http.Field

interface MockWebServerEndpoints : SampleNetworking {

    override suspend fun getEvents(): Response<EventResponse>

    override suspend fun checkIn(
        @Field("eventId") eventId: String?,
        @Field("name") name: String,
        @Field("email") email: String
    ): Response<Map<String, String>>

    override suspend fun getSections(): Response<SectionsResponse>
}