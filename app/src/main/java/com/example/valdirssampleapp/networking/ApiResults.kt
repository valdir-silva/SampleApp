package com.example.valdirssampleapp.networking

import com.example.valdirssampleapp.networking.data.response.sections.SectionsResponse

sealed class ApiSectionsResults {
    class Success(val sectionsList: SectionsResponse) : ApiSectionsResults()
    class ApiError(val statusCode: String) : ApiSectionsResults()
    data object ServerError : ApiSectionsResults()
}