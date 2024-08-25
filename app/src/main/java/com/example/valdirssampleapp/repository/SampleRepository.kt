package com.example.valdirssampleapp.repository

import com.example.valdirssampleapp.domain.SampleResult
import com.example.valdirssampleapp.domain.models.SectionsModel

interface SampleRepository {

    suspend fun getSections(): SampleResult<SectionsModel>
}