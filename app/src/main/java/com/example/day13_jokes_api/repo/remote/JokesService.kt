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
suspend fun getJokesWithResponse(@Path("category") category:String, @Query("amount") amount:Int ): List<JokeResponse>







}