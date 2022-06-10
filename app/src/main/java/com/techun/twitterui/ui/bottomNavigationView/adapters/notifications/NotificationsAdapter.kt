package com.techun.twitterui.ui.bottomNavigationView.adapters.notifications

import androidx.recyclerview.widget.AsyncListDiffer
import com.techun.twitterui.R
import com.techun.twitterui.domain.NotificartionModel
import javax.inject.Inject

class NotificationsAdapter @Inject constructor() : NotificationsBaseAdapter(R.layout.item_layout_notifications) {
    override val differ = AsyncListDiffer(this, diffCallback)
    fun submitList(list: List<NotificartionModel>) = differ.submitList(list)
    override fun onBindViewHolder(holder: NotificationsViewHolder, position: Int) {
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