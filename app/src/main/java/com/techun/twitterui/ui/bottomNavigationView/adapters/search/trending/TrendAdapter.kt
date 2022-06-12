package com.techun.twitterui.ui.bottomNavigationView.adapters.search.trending

import androidx.recyclerview.widget.AsyncListDiffer
import com.techun.twitterui.R
import com.techun.twitterui.domain.TrendModel
import javax.inject.Inject

class TrendAdapter @Inject constructor() : TrendBaseAdapter(R.layout.item_layout_trends) {
    override val differ = AsyncListDiffer(this, diffCallback)
    fun submitList(list: List<TrendModel>) = differ.submitList(list)
    override fun onBindViewHolder(holder: TrendViewHolder, position: Int) {
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