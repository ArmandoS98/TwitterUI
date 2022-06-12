package com.techun.twitterui.ui.bottomNavigationView.adapters.message

import androidx.recyclerview.widget.AsyncListDiffer
import com.techun.twitterui.R
import com.techun.twitterui.domain.MessageModel
import javax.inject.Inject

class MessageAdapter @Inject constructor() : MessageBaseAdapter(R.layout.item_layout_messages) {
    override val differ = AsyncListDiffer(this, diffCallback)
    fun submitList(list: List<MessageModel>) = differ.submitList(list)
    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
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