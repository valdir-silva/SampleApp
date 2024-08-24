package com.example.valdirssampleapp.repository

import com.example.valdirssampleapp.networking.ApiResults
import com.example.valdirssampleapp.networking.ApiSectionsResults
import com.example.valdirssampleapp.networking.ApiService
import com.example.valdirssampleapp.networking.SampleNetworking
import com.example.valdirssampleapp.networking.data.model.EventRequest
import java.io.IOException

class EventsRepositoryImpl : EventsRepository {

//    val service: Service =
//        if (BuildConfig.BUILD_TYPE == "mock") ApiService.mockEndpoints else ApiService.apiEndpoints

    private val service: SampleNetworking = ApiService.mockSampleNetworkingImpl

    override suspend fun getEvents(eventsResultCallback: (result: ApiResults) -> Unit) {
        try {
            val response = service.getEvents()
            if (response.isSuccessful) {
                val eventModelList = response.body()
                if (eventModelList != null) {
                    eventsResultCallback(ApiResults.Success(eventModelList))
                } else {
                    eventsResultCallback(ApiResults.ApiError(0))
                }
            } else {
                eventsResultCallback(ApiResults.ApiError(response.code()))
            }
        } catch (e: IOException) {
            eventsResultCallback(ApiResults.ApiError(2))
        } catch (e: Exception) {
            eventsResultCallback(ApiResults.ApiError(3))
        }
    }

    override suspend fun checkIn(
        eventRequest: EventRequest, checkInResultCallback: (result: ApiResults) -> Unit
    ) {
        try {
            val response = service.checkIn(
                eventId = eventRequest.eventId,
                name = eventRequest.name,
                email = eventRequest.email
            )
            if (response.isSuccessful) {
                val eventModelList = response.body()
                if (eventModelList != null) {
//                    checkInResultCallback(ApiResults.Success(mapOf()))
                } else {
                    checkInResultCallback(ApiResults.ApiError(response.code()))
                }
            } else {
                checkInResultCallback(ApiResults.ApiError(response.code()))
            }
        } catch (e: IOException) {
            checkInResultCallback(ApiResults.ApiError(2))
        } catch (e: Exception) {
            checkInResultCallback(ApiResults.ApiError(3))
        }
    }

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