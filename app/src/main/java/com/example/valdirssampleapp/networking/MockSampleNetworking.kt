package com.example.valdirssampleapp.networking

import co.infinum.retromock.meta.Mock
import co.infinum.retromock.meta.MockResponse
import com.example.valdirssampleapp.networking.data.response.sections.SectionsResponse
import retrofit2.Response
import retrofit2.http.GET

interface MockSampleNetworking : ISampleNetworking {

    @MockResponse(bodyFactory = CustomBuildBodyFactory::class)
    @Mock
    @GET("/")
    override suspend fun getSections(): Response<SectionsResponse>
}
