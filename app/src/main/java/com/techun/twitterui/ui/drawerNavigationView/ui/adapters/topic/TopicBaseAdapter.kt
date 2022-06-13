package com.techun.twitterui.ui.drawerNavigationView.ui.adapters.topic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.techun.twitterui.databinding.ItemLayoutFollowedBinding
import com.techun.twitterui.domain.TopicModel

abstract class TopicBaseAdapter(private val layoutId: Int) :
    RecyclerView.Adapter<TopicBaseAdapter.TopicViewHolder>() {

    class TopicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemLayoutFollowedBinding.bind(itemView)
        fun render(notification: TopicModel) {
            binding.tvUserName.text = notification.nameTopic
            binding.tvMessage.text = notification.descriptionTopics
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        return TopicViewHolder(
            LayoutInflater.from(parent.context).inflate(
                layoutId,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = spaces.size

    protected val diffCallback = object : DiffUtil.ItemCallback<TopicModel>() {
        override fun areItemsTheSame(
            oldItem: TopicModel,
            newItem: TopicModel
        ): Boolean {
            return oldItem.idTopic == newItem.idTopic
        }

        override fun areContentsTheSame(
            oldItem: TopicModel,
            newItem: TopicModel
        ): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    protected abstract val differ: AsyncListDiffer<TopicModel>

    open var spaces: List<TopicModel>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    protected var onItemClickListener: ((TopicModel) -> Unit)? = null
    protected var onDeleteClickListener: ((TopicModel) -> Unit)? = null

    fun setItemClickListener(listener: (TopicModel) -> Unit) {
        onItemClickListener = listener
    }

    fun setDeleteClickListener(listener: (TopicModel) -> Unit) {
        onDeleteClickListener = listener
    }

}