package com.techun.twitterui.ui.bottomNavigationView.adapters.spaces

import androidx.recyclerview.widget.AsyncListDiffer
import com.techun.twitterui.R
import com.techun.twitterui.domain.SpaceModel
import javax.inject.Inject

class SpacesAdapter @Inject constructor() : SpacesBaseAdapter(R.layout.item_layout_spaces) {
    override val differ = AsyncListDiffer(this, diffCallback)
    fun submitList(list: List<SpaceModel>) = differ.submitList(list)
    override fun onBindViewHolder(holder: SpacesViewHolder, position: Int) {
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