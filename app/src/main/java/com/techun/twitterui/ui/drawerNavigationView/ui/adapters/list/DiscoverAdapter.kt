package com.techun.twitterui.ui.drawerNavigationView.ui.adapters.list

import androidx.recyclerview.widget.AsyncListDiffer
import com.techun.twitterui.R
import com.techun.twitterui.domain.DiscoverModel
import javax.inject.Inject

class DiscoverAdapter @Inject constructor() : DiscoverBaseAdapter(R.layout.item_layout_discover) {
    override val differ = AsyncListDiffer(this, diffCallback)
    fun submitList(list: List<DiscoverModel>) = differ.submitList(list)
    override fun onBindViewHolder(holder: DiscoverViewHolder, position: Int) {
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