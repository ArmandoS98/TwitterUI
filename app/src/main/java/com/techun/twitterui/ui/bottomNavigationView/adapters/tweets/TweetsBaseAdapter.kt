package com.techun.twitterui.ui.bottomNavigationView.adapters.tweets

import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.techun.twitterui.R
import com.techun.twitterui.databinding.ItemLayoutTweetBinding
import com.techun.twitterui.domain.TweetModel
import com.techun.twitterui.utils.loadByResource
import com.techun.twitterui.utils.loadImageTweetsByResource


abstract class TweetsBaseAdapter : RecyclerView.Adapter<TweetsBaseAdapter.TweetViewHolder>() {

    class TweetViewHolder(val binding: ItemLayoutTweetBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun render(tweet: TweetModel) {
            binding.tvCommentsCounter.text = tweet.comments.toString()
            binding.tvRetweetsCounter.text = tweet.reTweets.toString()
            binding.tvLikesCounter.text = tweet.likes.toString()
            binding.tvUsername.text = tweet.username
            binding.tvName.text = tweet.name
            val body = tweet.text
            /*     val tst = body?.split(" ")?.map { word ->
                     if (!word.isNullOrEmpty())
                         if (word.trim().first() == '#' || word.trim().first() == '@') {
                             val spannableString = SpannableString(word)
                             spannableString.setSpan(
                                 StyleSpan(Typeface.BOLD),
                                 1,
                                 word.length,
                                 Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                             )

                             binding.tvTweetText.text = spannableString
                         }
                 }
     */
            /* val finalString = SpannableStringBuilder("")
             val specialText = ForegroundColorSpan(Color.BLUE)
             body?.split(".*?\\s(#\\w+).*?".toRegex())?.forEach { word ->
                 if (!word.isNullOrEmpty()) {
                     if (word.trim().first() == '#' || word.trim().first() == '@') {
                         val spannableString = SpannableStringBuilder(word)
                         spannableString.setSpan(
                             specialText,
                             1,
                             word.length,
                             Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                         )

                         spannableString.append("$spannableString ")
                         binding.tvTweetText.text = spannableString
                     } else {
                         *//*   finalString.append("$word ")
                           binding.tvTweetText.text = word*//*
                    }
                }
            }

            val YourString = "Today is a beautiful sunny day #sun. Hello my name is Mat #Sweet #Home"

            val REG_EX_TAG =  ".*?\\s(#\\w+).*?"
            val tagMatcher: Pattern = Pattern.compile(REG_EX_TAG, Pattern.MULTILINE)
            val m: Matcher = tagMatcher.matcher(YourString)
            while (m.find()) {
                for (i in 0 until m.groupCount()) {
                    println("tag ${i + 1} -> ${m.group(i + 1)}")
                }
            }*/

            binding.tvTweetText.text = body

            binding.tvDate.text = "${tweet.time}h"
            binding.tvTweetEdited.visibility = if (tweet.edited!!) VISIBLE else GONE

            if (!tweet.userImg.isNullOrEmpty())
                binding.profilePhoto.loadByResource(tweet.userImg!!)
            else
                binding.profilePhoto.loadByResource(R.drawable.egg)

            if (!tweet.image.isNullOrEmpty()) {
                binding.imgPostTwetter.visibility = VISIBLE
                binding.imgPostTwetter.loadImageTweetsByResource(tweet.image!!)
            } else
                binding.imgPostTwetter.visibility = GONE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetViewHolder {
        return TweetViewHolder(
            ItemLayoutTweetBinding.inflate(
                LayoutInflater.from(parent.context),
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
    protected var onOptionsClickListener: ((TweetModel) -> Unit)? = null
    protected var onImageTweetClickListener: ((TweetModel, ImageView) -> Unit)? = null

    fun setItemClickListener(listener: (TweetModel) -> Unit) {
        onItemClickListener = listener
    }

    fun setOptionsClickListener(listener: (TweetModel) -> Unit) {
        onOptionsClickListener = listener
    }

    fun setImageTweetClickListener(listener: (TweetModel,ImageView) -> Unit) {
        onImageTweetClickListener = listener
    }

}