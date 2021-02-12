package com.example.day13_jokes_api.repo.remote

import com.example.day13_jokes_api.model.JokeResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface JokesService {

//@GET("type")
//@GET("blacklistFlags")

//@GET("category")
//@GET("amount")
@GET("{category}")

/**
 * Implementation using kotlin coroutines multithreading mechanism
 *
 * suspend is a keyword that lets the compiler know this is a coroutine function
 */

// https://v2.jokeapi.dev/joke/any?amount=10
/*
    @Path(""): is used for url elements after the base url without ? before it
    ex: BASE_URL:https://v2.jokeapi.dev/joke/any,misc,xmas?amount=10

    @Path("category")

    @Get("") is used for url elements after the base url with ? before it
    @Get("amount")

 */
suspend fun getJokesWithResponse(@Path("category") category:String, @Query("amount") amount:Int ): List<JokeResponse>







}