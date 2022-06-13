package com.techun.twitterui.ui.drawerNavigationView.ui.adapters.monetization

import androidx.recyclerview.widget.AsyncListDiffer
import com.techun.twitterui.R
import javax.inject.Inject

class MonetizationAdapter @Inject constructor() :
    MonetizationBaseAdapter(R.layout.item_layout_monetization) {
    override val differ = AsyncListDiffer(this, diffCallback)
    fun submitList(list: List<String>) = differ.submitList(list)
    override fun onBindViewHolder(holder: MonetizationViewHolder, position: Int) {
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