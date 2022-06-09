package com.techun.twitterui.ui.bottomNavigationView.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.techun.twitterui.databinding.ItemlayoutTweetBinding
import com.techun.twitterui.domain.TweetModel

abstract class TweetsBaseAdapter(private val layoutId: Int) : RecyclerView.Adapter<TweetsBaseAdapter.TweetViewHolder>() {

    class TweetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemlayoutTweetBinding.bind(itemView)
        fun render(tweet: TweetModel) {
            binding.llComments.setOnClickListener {
                binding.tvTweetText.text = tweet.text
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetViewHolder {
        return TweetViewHolder(
            LayoutInflater.from(parent.context).inflate(
                layoutId,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = tweets.size

    protected val diffCallback = object : DiffUtil.ItemCallback<TweetModel>() {
        override fun areItemsTheSame(oldItem: TweetModel, newItem: TweetModel): Boolean {
            return oldItem.tweetId == newItem.tweetId
        }
        override fun areContentsTheSame(oldItem: TweetModel, newItem: TweetModel): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    protected abstract val differ: AsyncListDiffer<TweetModel>

    open var tweets: List<TweetModel>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    protected var onItemClickListener: ((TweetModel) -> Unit)? = null
    protected var onDeleteClickListener: ((TweetModel) -> Unit)? = null

    fun setItemClickListener(listener: (TweetModel) -> Unit) {
        onItemClickListener = listener
    }

    fun setDeleteClickListener(listener: (TweetModel) -> Unit) {
        onDeleteClickListener = listener
    }

}