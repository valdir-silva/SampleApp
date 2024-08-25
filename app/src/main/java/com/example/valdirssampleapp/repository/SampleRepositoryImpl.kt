package com.example.valdirssampleapp.repository

import com.example.valdirssampleapp.domain.SampleResult
import com.example.valdirssampleapp.networking.ApiService
import com.example.valdirssampleapp.networking.ISampleNetworking
import com.example.valdirssampleapp.networking.data.response.sections.SectionsResponse
import java.io.IOException

class SampleRepositoryImpl(apiService: ApiService) : SampleRepository {

//    val service: Service =
//        if (BuildConfig.BUILD_TYPE == "mock") ApiService.mockEndpoints else ApiService.apiEndpoints

    // TODO ajustar para ficar com menos acoplamento
    private val service: ISampleNetworking = apiService.mockSampleNetworking

    override suspend fun getSections(): SampleResult<SectionsResponse> = run {
        try {
            val response = service.getSections()
            if (response.isSuccessful) {
                val sections: SectionsResponse? = response.body()
                if (sections != null) {
                    return SampleResult.Success(sections)
                } else {
                    return SampleResult.Failure(Throwable(response.code().toString()))
                }
            } else {
                return SampleResult.Failure(Throwable(response.code().toString()))
            }
        } catch (e: IOException) {
            return SampleResult.Failure(e)
        } catch (e: Exception) {
            return SampleResult.Failure(e)
        }
    }
}