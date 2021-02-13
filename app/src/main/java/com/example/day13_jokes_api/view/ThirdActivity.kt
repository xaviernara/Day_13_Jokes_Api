package com.example.day13_jokes_api.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.day13_jokes_api.R
import com.example.day13_jokes_api.databinding.ActivitySecondBinding
import com.example.day13_jokes_api.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    lateinit var binding : ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.jokeText.text = intent.getStringExtra("joke").toString()
        binding.deliveryText.text = intent.getStringExtra("delivery").toString()

    }

    fun initToolbar(){
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(binding.toolbar)
    }

    // Menu icons are inflated just as they were with actionbar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    //https://developer.android.com/guide/topics/ui/menus#kotlin
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {

            R.id.menu_back->{
                //User will be sent to main actvity
                intent = Intent(this, SecondActivity::class.java)

                true
            }

            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            else -> super.onOptionsItemSelected(item)
        }

    }

}