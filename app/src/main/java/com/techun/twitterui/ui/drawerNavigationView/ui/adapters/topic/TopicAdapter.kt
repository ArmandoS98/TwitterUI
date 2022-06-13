package com.techun.twitterui.ui.drawerNavigationView.ui.adapters.topic

import androidx.recyclerview.widget.AsyncListDiffer
import com.techun.twitterui.R
import com.techun.twitterui.domain.TopicModel
import javax.inject.Inject

class TopicAdapter @Inject constructor() : TopicBaseAdapter(R.layout.item_layout_followed) {
    override val differ = AsyncListDiffer(this, diffCallback)
    fun submitList(list: List<TopicModel>) = differ.submitList(list)
    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        val bicho = spaces[position]
        holder.render(bicho)

        holder.itemView.apply {
            setOnClickListener {
                onItemClickListener?.let { click ->
                    click(bicho)
                }
            }
        }
    }
}