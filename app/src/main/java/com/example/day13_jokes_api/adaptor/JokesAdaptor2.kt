package com.example.day13_jokes_api.adaptor

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.day13_jokes_api.R
import com.example.day13_jokes_api.databinding.JokeRecyclerBinding
import com.example.day13_jokes_api.model.JokeResponse
import com.example.day13_jokes_api.view.SecondActivity
import com.example.day13_jokes_api.view.ThirdActivity


class JokesAdaptor2(val jokeResponseList: List<JokeResponse>) :
    RecyclerView.Adapter<JokesAdaptor2.JokesViewHolder>() {

    lateinit var binding: JokeRecyclerBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokesAdaptor2.JokesViewHolder {

        // Create a new view, which defines the UI of the list item
        binding = JokeRecyclerBinding.inflate(LayoutInflater.from(parent.context))

        return JokesViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return jokeResponseList.size
    }


    override fun onBindViewHolder(holder: JokesAdaptor2.JokesViewHolder, position: Int) {
        holder.setTextViews(
            jokeResponseList[position].joke,
            jokeResponseList[position].delivery
        )


    }

    class JokesViewHolder(private val binding: JokeRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {


        lateinit var intent: Intent

        fun setTextViews(joke: String, delivery: String) {
            binding.textView.text = joke

            binding.textView2.setOnLongClickListener {
                binding.textView2.text = delivery
                return@setOnLongClickListener true
            }


        }

        init {
            binding.textView.setOnClickListener(this)
            binding.textView2.setOnClickListener(this)
        }

        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         */
        override fun onClick(v: View?) {
            Log.d("RecyclerView", "CLICK!")

            var intent = Intent(binding.root.context, ThirdActivity::class.java)
            intent.putExtra("joke", binding.textView.text.toString())
            intent.putExtra("delivery", binding.textView2.text.toString())


            //val intent = Intent(binding.root,ThirdActivity::class.java)

        }


    }
}


