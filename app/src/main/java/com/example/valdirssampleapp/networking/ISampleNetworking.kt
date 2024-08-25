package com.example.valdirssampleapp.networking

import com.example.valdirssampleapp.networking.data.response.sections.SectionsResponse
import retrofit2.Response

interface ISampleNetworking {

    suspend fun getSections(): Response<SectionsResponse>
}