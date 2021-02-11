package com.example.day13_jokes_api.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Flags(

    @field:Json(name = "explicit")
    val explicit: Boolean,

    @field:Json(name = "nsfw")
    val nsfw: Boolean,

    @field:Json(name = "political")
    val political: Boolean,

    @field:Json(name = "racist")
    val racist: Boolean,

    @field:Json(name = "religious")
    val religious: Boolean,

    @field:Json(name = "sexist")
    val sexist: Boolean
)