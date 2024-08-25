package com.example.valdirssampleapp.repository

import com.example.valdirssampleapp.domain.SampleResult
import com.example.valdirssampleapp.networking.data.response.sections.SectionsResponse

interface SampleRepository {

    suspend fun getSections(): SampleResult<SectionsResponse>
}