package com.example.valdirssampleapp.networking

import com.example.valdirssampleapp.networking.data.response.sections.SectionsResponse
import retrofit2.Response
import retrofit2.http.GET

interface SampleNetworking : ISampleNetworking {

    @GET("sections/")
    override suspend fun getSections(): Response<SectionsResponse>
}