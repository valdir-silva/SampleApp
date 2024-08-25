package com.example.valdirssampleapp.repository

import com.example.valdirssampleapp.networking.ApiSectionsResults

interface SampleRepository {

    suspend fun getSections(resultCallback: (result: ApiSectionsResults) -> Unit)
}