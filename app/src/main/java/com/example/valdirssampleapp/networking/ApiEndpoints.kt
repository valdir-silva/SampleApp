package com.example.valdirssampleapp.networking

import com.example.valdirssampleapp.networking.data.response.EventResponse
import com.example.valdirssampleapp.networking.data.response.sections.SectionsResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiEndpoints : SampleNetworking {

    @GET("events/")
    override suspend fun getEvents(): Response<EventResponse>

    @FormUrlEncoded
    @POST("checkin/")
    override suspend fun checkIn(
        @Field("eventId") eventId: String?,
        @Field("name") name: String,
        @Field("email") email: String
    ): Response<Map<String, String>>

    @GET("sections/")
    override suspend fun getSections(): Response<SectionsResponse>
}