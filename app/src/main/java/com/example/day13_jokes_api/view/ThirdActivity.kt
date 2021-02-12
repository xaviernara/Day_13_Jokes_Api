package com.example.day13_jokes_api.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.day13_jokes_api.R
import com.example.day13_jokes_api.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    lateinit var binding : ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)


    }

    fun initToolbar(){
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(binding.toolbar)
    }
}