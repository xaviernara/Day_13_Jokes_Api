package com.example.day13_jokes_api.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.day13_jokes_api.model.JokeResponse
import com.example.day13_jokes_api.repo.remote.JokeRepo
import com.example.day13_jokes_api.repo.remote.JokesService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel :ViewModel(){

    private val _jokes = MutableLiveData<List<JokeResponse>>()

    //Initialize _jokes in Kotlin
    //Java: this._jokes = jokes
    val jokes: LiveData<List<JokeResponse>>
        get() = _jokes


    init {
        val callback : Callback<List<JokeResponse>> = object : Callback<List<JokeResponse>>{
            /**
             * Invoked when a network exception occurred talking to the server or when an unexpected exception
             * occurred creating the request or processing the response.
             */
            override fun onFailure(call: Call<List<JokeResponse>>, t: Throwable) {
                Log.e("VM Callback Error:","ONfAILURE", t)

            }

            /**
             * Invoked for a received HTTP response.
             *
             *
             * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
             * Call [Response.isSuccessful] to determine if the response indicates success.
             */
            override fun onResponse(call: Call<List<JokeResponse>>, response: Response<List<JokeResponse>>) {
                _jokes.value = response.body()
            }

        }


        viewModelScope.launch(Dispatchers.Main) {  JokeRepo.jokesService.getJokesWithResponse("any",10) }


    }

    fun getJokes(category : String, amount : Int){
       /*
        CoroutineScope tied to this ViewModel. This scope will be
        canceled when ViewModel will be cleared, i.e ViewModel.onCleared is called


        Launches a new coroutine without blocking the current thread and returns a reference to the coroutine as a Job.
        The coroutine is cancelled when the resulting job is cancelled.
        */
        viewModelScope.launch(Dispatchers.Main){
            val jokeList = JokeRepo.getJokes(category, amount)
            _jokes.value = jokeList
        }

    }

}