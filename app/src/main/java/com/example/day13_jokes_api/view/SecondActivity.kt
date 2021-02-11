package com.example.day13_jokes_api.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.day13_jokes_api.R
import com.example.day13_jokes_api.adaptor.JokesAdaptor2
import com.example.day13_jokes_api.databinding.ActivityMainBinding
import com.example.day13_jokes_api.databinding.ActivitySecondBinding
import com.example.day13_jokes_api.model.JokeResponse
import com.example.day13_jokes_api.viewmodel.MainViewModel
import java.util.*

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

        val bundle : Bundle? =intent.extras
        val anyCategory = bundle?.get("anyCategory")
        val miscCategory = bundle?.get("miscCategory")
        val punCategory = bundle?.get("punCategory")
        val xmasCategory = bundle?.get("xmasCategory")
        val darkCategory = bundle?.get("darkCategory")
        val spookyCategory = bundle?.get("spookyCategory")
        val amountText = bundle?.get("amount")


        viewModel.getJokes(spookyCategory as String, amountText as Int)
        initViews()


    }


    fun initViews() {

        binding.gridButton.setOnClickListener(this)
        binding.linearButton.setOnClickListener(this)

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


    private fun generateDataListGrid(jokeResponse: List<JokeResponse>){
        adapter = JokesAdaptor2(jokeResponse)
        binding.jokeRecycler.adapter = adapter
        gridLayoutManager = GridLayoutManager(this,2)
        binding.jokeRecycler.layoutManager = gridLayoutManager




    }
}