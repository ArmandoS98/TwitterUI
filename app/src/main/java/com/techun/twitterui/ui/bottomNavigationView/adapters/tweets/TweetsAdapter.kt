package com.techun.twitterui.ui.bottomNavigationView.adapters.tweets

import androidx.recyclerview.widget.AsyncListDiffer
import com.techun.twitterui.domain.TweetModel
import javax.inject.Inject

class TweetsAdapter @Inject constructor() : TweetsBaseAdapter() {
    override val differ = AsyncListDiffer(this, diffCallback)
    fun submitList(list: List<TweetModel>) = differ.submitList(list)

    override fun onBindViewHolder(holder: TweetViewHolder, position: Int) {
        val bicho = tweets[position]
        holder.render(bicho)
        holder.binding.imgMore.setOnClickListener {
            onOptionsClickListener?.let { click ->
                click(bicho)
            }
        }
        holder.binding.imgPostTwetter.setOnClickListener {
            onImageTweetClickListener?.let { click ->
                click(bicho, holder.binding.imgPostTwetter)
            }
        }

        holder.itemView.apply {
            setOnClickListener {
                onItemClickListener?.let { click ->
                    click(bicho)
                }
            }
        }
    }
}