package com.artelsv.petstudyapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.artelsv.petstudyapp.data.model.Movie
import com.artelsv.petstudyapp.databinding.ItemMovieBinding
import com.artelsv.petstudyapp.utils.DefaultDiffCallback

class MovieAdapter(
    private val onClickListener: OnClickListener
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    var data = listOf<Movie>()
        set(value) {
            field = value

            val diffCallback = DefaultDiffCallback(field, value)
            val diffResult = DiffUtil.calculateDiff(diffCallback)
            diffResult.dispatchUpdatesTo(this)

            field = value
        }

    class ViewHolder private constructor(
        val binding: ItemMovieBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            item: Movie,
            onClickListener: OnClickListener
        ) {
            binding.item = item
            binding.ivBackground.load(item.getImageUrl())
            binding.tvVote.setTextColor(binding.root.resources.getColor(item.getVoteColor(), binding.root.resources.newTheme()))
            binding.mcvMovie.setOnClickListener {
                onClickListener.onClick(item)
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val binding = ItemMovieBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )

                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]

        holder.bind(item, onClickListener)
    }

    override fun getItemCount() = data.size

    class OnClickListener(val clickListener: (clickData: Movie) -> Unit) {
        fun onClick(clickData: Movie) = clickListener(clickData)
    }
}

