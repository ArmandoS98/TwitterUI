package com.techun.twitterui.ui.drawerNavigationView

import androidx.recyclerview.widget.AsyncListDiffer
import com.techun.twitterui.R
import javax.inject.Inject

class NavigationRVAdapter @Inject constructor() : NavigationBaseRVAdapter(R.layout.row_nav_drawer) {
    override val differ = AsyncListDiffer(this, diffCallback)
    fun submitList(list: List<NavigationItemModel>) = differ.submitList(list)

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = games[position]
        holder.render(game)
        holder.itemView.apply {
            setOnClickListener {
                onItemClickListener?.let { click ->
                    click(game)
                }
            }
        }
    }
}


