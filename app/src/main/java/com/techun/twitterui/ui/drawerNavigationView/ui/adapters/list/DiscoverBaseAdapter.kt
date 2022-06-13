package com.techun.twitterui.ui.drawerNavigationView.ui.adapters.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.techun.twitterui.R
import com.techun.twitterui.databinding.ItemLayoutDiscoverBinding
import com.techun.twitterui.domain.DiscoverModel
import com.techun.twitterui.utils.loadByResource

abstract class DiscoverBaseAdapter(private val layoutId: Int) :
    RecyclerView.Adapter<DiscoverBaseAdapter.DiscoverViewHolder>() {

    class DiscoverViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemLayoutDiscoverBinding.bind(itemView)
        fun render(discover: DiscoverModel) {
            val userProfile = discover.imageProfile
            if (!userProfile.isNullOrEmpty())
                binding.civUserProfile.loadByResource(userProfile)
            else
                binding.civUserProfile.loadByResource(R.drawable.egg)

            binding.tvTitle.text = discover.title
            binding.tvDescription.text = discover.description
            binding.tvUserName.text = discover.userName
            binding.tvTitleTwitter.text = discover.userNameTwitter
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscoverViewHolder {
        return DiscoverViewHolder(
            LayoutInflater.from(parent.context).inflate(
                layoutId,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = spaces.size

    protected val diffCallback = object : DiffUtil.ItemCallback<DiscoverModel>() {
        override fun areItemsTheSame(
            oldItem: DiscoverModel,
            newItem: DiscoverModel
        ): Boolean {
            return oldItem.idDiscover == newItem.idDiscover
        }

        override fun areContentsTheSame(
            oldItem: DiscoverModel,
            newItem: DiscoverModel
        ): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    protected abstract val differ: AsyncListDiffer<DiscoverModel>

    open var spaces: List<DiscoverModel>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    protected var onItemClickListener: ((DiscoverModel) -> Unit)? = null
    protected var onDeleteClickListener: ((DiscoverModel) -> Unit)? = null

    fun setItemClickListener(listener: (DiscoverModel) -> Unit) {
        onItemClickListener = listener
    }

    fun setDeleteClickListener(listener: (DiscoverModel) -> Unit) {
        onDeleteClickListener = listener
    }

}