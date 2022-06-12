package com.techun.twitterui.ui.bottomNavigationView.adapters.search.whoToFollow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.techun.twitterui.R
import com.techun.twitterui.databinding.ItemLayoutWhoToFollowBinding
import com.techun.twitterui.domain.WhoToFollowModel
import com.techun.twitterui.utils.loadByResource

abstract class WhoToFollowBaseAdapter(private val layoutId: Int) :
    RecyclerView.Adapter<WhoToFollowBaseAdapter.WhoToFollowViewHolder>() {

    class WhoToFollowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemLayoutWhoToFollowBinding.bind(itemView)
        fun render(notification: WhoToFollowModel) {
            val userProfile = notification.urlImage
            if (!userProfile.isNullOrEmpty())
                binding.civImageProfile.loadByResource(userProfile)
            else
                binding.civImageProfile.loadByResource(R.drawable.egg)

            binding.tvUserName.text = notification.userName
            binding.tvUserNameTwitter.text = notification.userNameTwitter
            binding.tvFollows.text = notification.followBy
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WhoToFollowViewHolder {
        return WhoToFollowViewHolder(
            LayoutInflater.from(parent.context).inflate(
                layoutId,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = spaces.size

    protected val diffCallback = object : DiffUtil.ItemCallback<WhoToFollowModel>() {
        override fun areItemsTheSame(
            oldItem: WhoToFollowModel,
            newItem: WhoToFollowModel
        ): Boolean {
            return oldItem.idWhoToFollow == newItem.idWhoToFollow
        }

        override fun areContentsTheSame(
            oldItem: WhoToFollowModel,
            newItem: WhoToFollowModel
        ): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    protected abstract val differ: AsyncListDiffer<WhoToFollowModel>

    open var spaces: List<WhoToFollowModel>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    protected var onItemClickListener: ((WhoToFollowModel) -> Unit)? = null
    protected var onDeleteClickListener: ((WhoToFollowModel) -> Unit)? = null

    fun setItemClickListener(listener: (WhoToFollowModel) -> Unit) {
        onItemClickListener = listener
    }

    fun setDeleteClickListener(listener: (WhoToFollowModel) -> Unit) {
        onDeleteClickListener = listener
    }

}