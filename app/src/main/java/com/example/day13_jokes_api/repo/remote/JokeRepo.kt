package com.example.day13_jokes_api.repo.remote

import com.example.day13_jokes_api.model.JokeResponse

object JokeRepo {

    val jokesService = RetrofitInstance.jokeService;

    suspend fun getJokes(category:String, amount : Int):List<JokeResponse> {
        return RetrofitInstance.jokeService.getJokesWithResponse(category, amount)
    }




}