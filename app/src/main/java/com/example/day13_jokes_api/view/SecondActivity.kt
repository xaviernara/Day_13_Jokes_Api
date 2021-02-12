package com.example.day13_jokes_api.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.day13_jokes_api.R
import com.example.day13_jokes_api.adaptor.JokesAdaptor2
import com.example.day13_jokes_api.databinding.ActivitySecondBinding
import com.example.day13_jokes_api.model.JokeResponse
import com.example.day13_jokes_api.viewmodel.MainViewModel


class SecondActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding : ActivitySecondBinding
    private lateinit var adapter: JokesAdaptor2
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var gridLayoutManager: GridLayoutManager

    private lateinit var viewModel : MainViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initToolbar()


        val bundle : Bundle? =intent.extras
        /*val anyCategory = bundle?.get("anyCategory")
        val miscCategory = bundle?.get("miscCategory")
        val punCategory = bundle?.get("punCategory")
        val xmasCategory = bundle?.get("xmasCategory")
        val darkCategory = bundle?.get("darkCategory")
        val spookyCategory = bundle?.get("spookyCategory")*/
        /*val category = bundle?.get("categoryText")
        val amountText = bundle?.get("amount")*/
        val category = intent.getStringExtra("categoryText").toString()
        val amountText = intent.getIntExtra("amount",10)



        //viewModel.getJokes(category as String, amountText as Int)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getJokes(category, amountText)
        initViews()


    }


    fun initViews() {

        binding.gridButton.setOnClickListener(this)
        binding.linearButton.setOnClickListener(this)

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
                intent = Intent(this, MainActivity::class.java)

                true
            }

            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            else -> super.onOptionsItemSelected(item)
        }

    }



    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    override fun onClick(v: View?) {

        if (v != null) {
            if(v.id == R.id.gridButton){

                viewModel.jokes?.observe(this, androidx.lifecycle.Observer {
                    generateDataList(it)
                })
            }

            else{
                viewModel.jokes?.observe(this, androidx.lifecycle.Observer {
                    generateDataListGrid(it)
                })
            }
        }
    }

   private fun generateDataList(jokeResponse: List<JokeResponse>){
       adapter = JokesAdaptor2(jokeResponse)
       binding.jokeRecycler.adapter = adapter
       binding.jokeRecycler.layoutManager = linearLayoutManager



   }


    private fun generateDataListGrid(jokeResponseList: List<JokeResponse>){
        adapter = JokesAdaptor2(jokeResponseList)
        binding.jokeRecycler.adapter = adapter
        gridLayoutManager = GridLayoutManager(this,2)
        binding.jokeRecycler.layoutManager = gridLayoutManager




    }
}