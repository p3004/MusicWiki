package com.music.wiki.ui.genres.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.music.wiki.R
import com.music.wiki.data.model.Tag
import com.music.wiki.data.model.TopGenre
import kotlinx.android.synthetic.main.single_genre_item.view.*


/**
 * Created by Pallab Banerjee on 2/23/2021.
 */
class TopGenreAdapter :
    ListAdapter<TopGenre, TopGenreAdapter.TopGenreViewHolder>(TopGenreDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopGenreViewHolder {
        return TopGenreViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.single_genre_item,parent,false))
    }

    override fun onBindViewHolder(holder: TopGenreViewHolder, position: Int) {
        holder.bind(getItem(position).toptags.tag[position])
    }

    class TopGenreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvTopTag: MaterialTextView = itemView.tvTopTag

        fun bind(tag: Tag) {
            tvTopTag.text = tag.name
        }

    }
}

private class TopGenreDiffCallback : DiffUtil.ItemCallback<TopGenre>() {
    override fun areItemsTheSame(oldItem: TopGenre, newItem: TopGenre): Boolean {
        return oldItem.toptags.tag == newItem.toptags.tag
    }

    override fun areContentsTheSame(oldItem: TopGenre, newItem: TopGenre): Boolean {
        return oldItem == newItem
    }


}