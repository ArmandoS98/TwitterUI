package com.techun.twitterui.ui.bottomNavigationView.adapters.message

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.techun.twitterui.R
import com.techun.twitterui.databinding.ItemLayoutMessagesBinding
import com.techun.twitterui.domain.MessageModel
import com.techun.twitterui.utils.loadByResource

abstract class MessageBaseAdapter(private val layoutId: Int) :
    RecyclerView.Adapter<MessageBaseAdapter.MessageViewHolder>() {

    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemLayoutMessagesBinding.bind(itemView)
        fun render(notification: MessageModel) {
            val userProfile = notification.userImageProfile
            if (!userProfile.isNullOrEmpty())
                binding.civUserProfile.loadByResource(userProfile)
            else
                binding.civUserProfile.loadByResource(R.drawable.egg)

            binding.tvUserName.text = notification.userName
            binding.tvUserNameTwitter.text = notification.userNameTwitter
            binding.tvMessage.text = notification.message
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(
            LayoutInflater.from(parent.context).inflate(
                layoutId,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = spaces.size

    protected val diffCallback = object : DiffUtil.ItemCallback<MessageModel>() {
        override fun areItemsTheSame(
            oldItem: MessageModel,
            newItem: MessageModel
        ): Boolean {
            return oldItem.idMessage == newItem.idMessage
        }

        override fun areContentsTheSame(
            oldItem: MessageModel,
            newItem: MessageModel
        ): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    protected abstract val differ: AsyncListDiffer<MessageModel>

    open var spaces: List<MessageModel>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    protected var onItemClickListener: ((MessageModel) -> Unit)? = null
    protected var onDeleteClickListener: ((MessageModel) -> Unit)? = null

    fun setItemClickListener(listener: (MessageModel) -> Unit) {
        onItemClickListener = listener
    }

    fun setDeleteClickListener(listener: (MessageModel) -> Unit) {
        onDeleteClickListener = listener
    }

}