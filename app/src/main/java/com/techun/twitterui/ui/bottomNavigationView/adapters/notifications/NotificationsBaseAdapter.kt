package com.techun.twitterui.ui.bottomNavigationView.adapters.notifications

import android.graphics.Typeface
import android.text.SpannableString
import android.text.style.StyleSpan
import android.text.style.TypefaceSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.techun.twitterui.R
import com.techun.twitterui.databinding.ItemLayoutNotificationsBinding
import com.techun.twitterui.domain.NotificartionModel
import com.techun.twitterui.utils.loadByResource

abstract class NotificationsBaseAdapter(private val layoutId: Int) :
    RecyclerView.Adapter<NotificationsBaseAdapter.NotificationsViewHolder>() {
    class NotificationsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemLayoutNotificationsBinding.bind(itemView)
        fun render(notification: NotificartionModel) {
            val userProfile = notification.userProfile
            if (!userProfile.isNullOrEmpty())
                binding.civUserProfile.loadByResource(userProfile)
            else
                binding.civUserProfile.loadByResource(R.drawable.egg)
            val title = itemView.context.getString(R.string.tweet_notifications)
            binding.tvName.text = "$title ${notification.title}"
            val spannableString = SpannableString(binding.tvName.text)
            spannableString.setSpan(
                StyleSpan(Typeface.BOLD),
                title.length,
                binding.tvName.length(),
                0
            )
            binding.tvName.text = spannableString
            binding.tvTweetText.text = notification.descriptions
            binding.tvCommentsCounter.text = notification.comments.toString()
            binding.tvRetweetsCounter.text = notification.reTweets.toString()
            binding.tvLikesCounter.text = notification.likes.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationsViewHolder {
        return NotificationsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                layoutId,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = spaces.size

    protected val diffCallback = object : DiffUtil.ItemCallback<NotificartionModel>() {
        override fun areItemsTheSame(
            oldItem: NotificartionModel,
            newItem: NotificartionModel
        ): Boolean {
            return oldItem.idNotification == newItem.idNotification
        }

        override fun areContentsTheSame(
            oldItem: NotificartionModel,
            newItem: NotificartionModel
        ): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    protected abstract val differ: AsyncListDiffer<NotificartionModel>

    open var spaces: List<NotificartionModel>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    protected var onItemClickListener: ((NotificartionModel) -> Unit)? = null
    protected var onDeleteClickListener: ((NotificartionModel) -> Unit)? = null

    fun setItemClickListener(listener: (NotificartionModel) -> Unit) {
        onItemClickListener = listener
    }

    fun setDeleteClickListener(listener: (NotificartionModel) -> Unit) {
        onDeleteClickListener = listener
    }

}