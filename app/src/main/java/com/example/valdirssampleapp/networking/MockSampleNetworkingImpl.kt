package com.example.valdirssampleapp.networking

import android.content.Context
import co.infinum.retromock.BodyFactory
import co.infinum.retromock.meta.Mock
import co.infinum.retromock.meta.MockResponse
import com.example.valdirssampleapp.networking.data.response.EventResponse
import com.example.valdirssampleapp.networking.data.response.sections.SectionsResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import java.io.IOException
import java.io.InputStream


interface MockSampleNetworkingImpl : SampleNetworking {

    @MockResponse(body = "events.json")
    @Mock
    @GET("/")
    override suspend fun getEvents(): Response<EventResponse>

    @MockResponse(body = "checkin.json")
    @Mock
    @FormUrlEncoded
    @POST("/")
    override suspend fun checkIn(
        @Field("eventId") eventId: String?,
        @Field("name") name: String,
        @Field("email") email: String
    ): Response<Map<String, String>>

    @MockResponse(bodyFactory = CustomBuildBodyFactory::class)
    @Mock
    @GET("/")
    override suspend fun getSections(): Response<SectionsResponse>
}

internal class CustomBuildBodyFactory(private val context: Context) : BodyFactory {
    @Throws(IOException::class)
    override fun create(input: String): InputStream {
        val inputStream = context.assets.open(ApiService.jsonPath)
        return inputStream
    }
}