package com.example.day13_jokes_api.adaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.day13_jokes_api.databinding.JokeRecyclerBinding
import com.example.day13_jokes_api.model.JokeResponse


class JokesAdaptor2(val jokeResponseList : List<JokeResponse>) : RecyclerView.Adapter<JokesAdaptor2.JokesViewHolder>() {

    lateinit var binding : JokeRecyclerBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokesAdaptor2.JokesViewHolder {
        binding = JokeRecyclerBinding.inflate(LayoutInflater.from(parent.context))

        return JokesViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return jokeResponseList.size
    }


    override fun onBindViewHolder(holder: JokesAdaptor2.JokesViewHolder, position: Int) {
        TODO("Not yet implemented")

        holder.setTextViews(jokeResponseList.get(position).joke,jokeResponseList.get(position).delivery)


    }

    class JokesViewHolder(private val binding: JokeRecyclerBinding) : RecyclerView.ViewHolder(binding.root){

        fun setTextViews(joke: String, delivery: String){
            binding.textView.text=joke
            binding.textView2.setOnLongClickListener{
                binding.textView2.text = delivery
                return@setOnLongClickListener true
            }


        }



    }
}


