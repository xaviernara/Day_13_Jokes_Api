/*

package com.example.day13_jokes_api.adaptor

import android.content.Intent
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.day13_jokes_api.R
import com.example.day13_jokes_api.databinding.JokeRecyclerBinding
import com.example.day13_jokes_api.model.JokeResponse
import com.example.day13_jokes_api.view.MainActivity

//Kotlin Recyclerview https://www.raywenderlich.com/1560485-android-recyclerview-tutorial-with-kotlin
class JokesAdapter(private val jokesResponseList: ArrayList<JokeResponse>) :
    RecyclerView.Adapter<JokesAdapter.JokesViewHolder> {

*/
/*
    *//*

*/
/*
     * Called when RecyclerView needs a new [ViewHolder] of the given type to represent
     * an item.
     *
     *
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     *
     *
     * The new ViewHolder will be used to display items of the adapter using
     * [.onBindViewHolder]. Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary [View.findViewById] calls.
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     * an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return A new ViewHolder that holds a View of the given view type.
     * @see .getItemViewType
     * @see .onBindViewHolder
     *//*
*/
/*

    *//*

*/
/*
        Here you inflate the view from its layout and pass it in to a JokeViewHolder.
        The parent.inflate(R.layout.recyclerview_item_row, false) method will execute the new
        ViewGroup.inflate(...) extension function to inflate the layout.







     *//*
*/
/*



    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): JokesAdapter.JokesViewHolder {
        val inflatedView = parent.inflate(R.layout.joke_recycler, false)
        return JokesViewHolder(inflatedView)
    }

    *//*

*/
/**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     *//*
*/
/*

    override fun getItemCount(): Int {
        return jokesResponseList.size
    }


    *//*

*/
/*
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the [ViewHolder.itemView] to reflect the item at the given
     * position.
     *
     *
     * Note that unlike [android.widget.ListView], RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the `position` parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use [ViewHolder.getAdapterPosition] which will
     * have the updated adapter position.
     *
     * Override [.onBindViewHolder] instead if Adapter can
     * handle efficient partial bind.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the
     * item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     *//*
*/
/*

    override fun onBindViewHolder(holder: JokesAdapter.JokesViewHolder, position: Int) {
        TODO("Not yet implemented")
        holder.addJokeToText(jokesResponseList.get(int))

    }


    //-----------------------------viewholder class-----------------------//

    *//*

*/
/*
         create a nested class in your adapter.
         You’ll add it here rather than in a separate class because
         its behavior is tightly coupled with the adapter.
     *//*
*/
/*


    //1
    class JokesAdaptor(v: View) : RecyclerView.ViewHolder(v) View.OnClickListener
    {

        *//*

*/
/*
            Here’s what the code above does:

            1.  Make the class extend RecyclerView.ViewHolder, allowing the adapter to use it as as a ViewHolder.

            2.  Add a reference to the view you’ve inflated to allow the ViewHolder
                to access the ImageView and TextView as an extension property.
                Kotlin Android Extensions plugin adds hidden caching functions and fields to prevent the constant querying of views.

            3.  Initialize the View.OnClickListener.

            4. Implement the required method for View.OnClickListener since
                ViewHolders are responsible for their own event handling.

            5. Add a key for easy reference to the item launching the RecyclerView.
         *//*
*/
/*



        //2
        private var binding: JokeRecyclerBinding
        private var view: View = v

        //3
        init {
            binding.textView.setOnClickListener(this)
            binding.textView2.setOnClickListener(this)
        }

        //4
        override fun onClick(v: View) {
            Log.d("RecyclerView", "CLICK!")
            val context: v.context
            lateinit var intent: Intent(context, SecondActivity::class.java)


        }

        //5
        companion
        val value = object {
            private val JOKE_KEY = "JOKE"
        }

        fun addJokeToText(joke: String, jokeDelivery: String) {

            binding.textView.text(joke)
            binding.textView.setOnLongClickListener(

                binding.textView2.text(jokeDelivery)
            )
        }


    }




}
*/
