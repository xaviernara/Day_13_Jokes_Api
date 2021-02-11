package com.example.day13_jokes_api.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class JokeResponse(

    /**
     * @JsonClass(generateAdapter = true)
     * Moshi uses the code above to help parse into the data class you created
     *
     * @field:Json(name = "")
     * Moshi uses the code above as the key for the incoming json property
     * use this if the variable name will be differnt from the json key name
     */


    @field:Json(name = "category")
    val category: String,

    @field:Json(name = "error")
    val error: Boolean,

    @field:Json(name = "flags")
    val flags: Flags,
    val id: Int,

    @field:Json(name = "joke")
    val joke: String,

    @field:Json(name = "lang")
    val lang: String,

    @field:Json(name = "safe")
    val safe: Boolean,

    @field:Json(name = "type")
    val type: String,

    @field:Json(name ="delivery")
        val delivery: String


)