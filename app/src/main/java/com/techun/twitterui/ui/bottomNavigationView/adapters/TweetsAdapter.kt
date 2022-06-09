package com.techun.twitterui.ui.bottomNavigationView.adapters

import android.widget.LinearLayout
import androidx.recyclerview.widget.AsyncListDiffer
import com.techun.twitterui.R
import com.techun.twitterui.domain.TweetModel
import javax.inject.Inject

class TweetsAdapter @Inject constructor() : TweetsBaseAdapter(R.layout.itemlayout_tweet) {

    override val differ = AsyncListDiffer(this, diffCallback)
    fun submitList(list: List<TweetModel>) = differ.submitList(list)

    override fun onBindViewHolder(holder: TweetViewHolder, position: Int) {
        val bicho = tweets[position]

        holder.render(bicho)

   /*     holder.itemView.findViewById<LinearLayout>(R.id.llComments).setOnClickListener {
            onDeleteClickListener?.let { click ->
                click(bicho)
            }
        }*/

        holder.itemView.apply {

            setOnClickListener {
                onItemClickListener?.let { click ->
                    click(bicho)
                }
            }
        }
    }
}