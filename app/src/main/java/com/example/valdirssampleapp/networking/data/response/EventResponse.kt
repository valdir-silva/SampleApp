package com.example.valdirssampleapp.networking.data.response

import com.example.valdirssampleapp.networking.data.model.EventModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EventResponse(
//    @Json(name = "people")
//    val List<People>: List<People>,
    @Json(name = "date")
    val date: Long,
    @Json(name = "description")
    val description: String,
    @Json(name = "image")
    val image: String,
    @Json(name = "longitude")
    val longitude: Double,
    @Json(name = "latitude")
    val latitude: Double,
    @Json(name = "price")
    val price: Float,
    @Json(name = "title")
    val title: String,
    @Json(name = "id")
    val id: String,
//    @Json(name = "section")
//    val section: SectionResponse? = SectionResponse.TextSectionResponse("TEXT", "")
) {
    fun getEventModel() = EventModel(
//        people = this.people
        date = this.date,
        description = this.description,
        image = this.image,
        price = this.price,
        title = this.title
    )
}