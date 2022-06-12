package com.techun.twitterui.ui.bottomNavigationView.adapters.search.whoToFollow

import androidx.recyclerview.widget.AsyncListDiffer
import com.techun.twitterui.R
import com.techun.twitterui.domain.WhoToFollowModel
import javax.inject.Inject

class WhoToFollowAdapter @Inject constructor() :
    WhoToFollowBaseAdapter(R.layout.item_layout_who_to_follow) {
    override val differ = AsyncListDiffer(this, diffCallback)
    fun submitList(list: List<WhoToFollowModel>) = differ.submitList(list)
    override fun onBindViewHolder(holder: WhoToFollowViewHolder, position: Int) {
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