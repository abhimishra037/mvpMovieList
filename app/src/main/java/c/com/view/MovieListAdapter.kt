package c.com.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import c.com.movieappdemo.R
import c.com.movieappdemo.model.Movies

class MovieListAdapter( private val movieList: ArrayList<Movies>): RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
         var textView: TextView = view.findViewById(R.id.txtMovieTitle)

        init {
            // Define click listener for the ViewHolder's View.
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_item_movie_list, parent, false)

        return ViewHolder(view)    }

    override fun getItemCount()= movieList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = movieList[position].getTitle()
    }
}