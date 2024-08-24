package com.example.valdirssampleapp.networking

import com.example.valdirssampleapp.networking.data.response.EventResponse
import com.example.valdirssampleapp.networking.data.response.sections.SectionsResponse

sealed class ApiResults {
    class Success(val eventModelList: EventResponse) : ApiResults()
    class ApiError(val statusCode: Int) : ApiResults()
    data object ServerError : ApiResults()
}

sealed class ApiSectionsResults {
    class Success(val sectionsList: SectionsResponse) : ApiSectionsResults()
    class ApiError(val statusCode: String) : ApiSectionsResults()
    data object ServerError : ApiSectionsResults()
}