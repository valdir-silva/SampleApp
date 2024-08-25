package com.example.valdirssampleapp.repository

import com.example.valdirssampleapp.networking.ApiSectionsResults
import com.example.valdirssampleapp.networking.ApiService
import com.example.valdirssampleapp.networking.ISampleNetworking
import java.io.IOException

class SampleRepositoryImpl(apiService: ApiService) : SampleRepository {

//    val service: Service =
//        if (BuildConfig.BUILD_TYPE == "mock") ApiService.mockEndpoints else ApiService.apiEndpoints

    private val service: ISampleNetworking = apiService.mockSampleNetworking

    override suspend fun getSections(resultCallback: (result: ApiSectionsResults) -> Unit) {
        try {
            val response = service.getSections()
            if (response.isSuccessful) {
                response.body()?.let { sections ->
                    resultCallback(ApiSectionsResults.Success(sections))
                } ?: {
                    resultCallback(ApiSectionsResults.ApiError(response.code().toString()))
                }
            } else {
                resultCallback(ApiSectionsResults.ApiError(response.code().toString()))
            }
        } catch (e: IOException) {
            resultCallback(ApiSectionsResults.ApiError(e.message.orEmpty()))
        } catch (e: Exception) {
            resultCallback(ApiSectionsResults.ApiError(e.message.orEmpty()))
        }
    }
}