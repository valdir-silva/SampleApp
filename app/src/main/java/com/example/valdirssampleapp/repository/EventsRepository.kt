package com.example.valdirssampleapp.repository

import com.example.valdirssampleapp.networking.ApiResults
import com.example.valdirssampleapp.networking.ApiSectionsResults
import com.example.valdirssampleapp.networking.data.model.EventRequest

interface EventsRepository {

    suspend fun getEvents(eventsResultCallback: (result: ApiResults) -> Unit)

    suspend fun checkIn(eventRequest: EventRequest, checkInResultCallback: (result: ApiResults) -> Unit)

    suspend fun getSections(resultCallback: (result: ApiSectionsResults) -> Unit)
}