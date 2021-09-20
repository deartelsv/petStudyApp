package com.artelsv.petstudyapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.artelsv.petstudyapp.databinding.ItemMovieBinding
import com.artelsv.petstudyapp.domain.model.Movie
import com.artelsv.petstudyapp.utils.DefaultDiffCallback

class MovieAdapter(
    private val clickListener: (clickData: Movie) -> Unit
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    var data = listOf<Movie>()
        set(value) {
            val diffCallback = DefaultDiffCallback(field, value)
            val diffResult = DiffUtil.calculateDiff(diffCallback)
            diffResult.dispatchUpdatesTo(this)

            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]

        holder.bind(item, clickListener)
    }

    override fun getItemCount() = data.size

    class OnClickListener(val clickListener: (clickData: Movie) -> Unit) {
        fun onClick(clickData: Movie) = clickListener(clickData)
    }
}

