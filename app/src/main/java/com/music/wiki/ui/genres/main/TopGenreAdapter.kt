package com.music.wiki.ui.genres.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.music.wiki.R
import com.music.wiki.data.model.top.Tag
import kotlinx.android.synthetic.main.single_genre_item.view.*


/**
 * Created by Pallab Banerjee on 2/23/2021.
 */
class TopGenreAdapter :
    ListAdapter<Tag, TopGenreAdapter.TopGenreViewHolder>(TopGenreDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopGenreViewHolder {
        return TopGenreViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.single_genre_item,parent,false))
    }

    override fun onBindViewHolder(holder: TopGenreViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class TopGenreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvTopTag: MaterialTextView = itemView.tvTopTag

        fun bind(tag: Tag) {
            tvTopTag.text = tag.name
        }

    }
}

private class TopGenreDiffCallback : DiffUtil.ItemCallback<Tag>() {
    override fun areItemsTheSame(oldItem: Tag, newItem: Tag): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Tag, newItem: Tag): Boolean {
        return oldItem == newItem
    }


}