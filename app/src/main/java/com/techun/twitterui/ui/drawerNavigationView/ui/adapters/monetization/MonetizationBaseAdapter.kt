package com.techun.twitterui.ui.drawerNavigationView.ui.adapters.monetization

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.techun.twitterui.databinding.ItemLayoutMonetizationBinding

abstract class MonetizationBaseAdapter(private val layoutId: Int) :
    RecyclerView.Adapter<MonetizationBaseAdapter.MonetizationViewHolder>() {

    class MonetizationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemLayoutMonetizationBinding.bind(itemView)
        fun render(notification: String) {
            binding.tvOptionsName.text = notification
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonetizationViewHolder {
        return MonetizationViewHolder(
            LayoutInflater.from(parent.context).inflate(
                layoutId,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = spaces.size

    protected val diffCallback = object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(
            oldItem: String,
            newItem: String
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: String,
            newItem: String
        ): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    protected abstract val differ: AsyncListDiffer<String>

    open var spaces: List<String>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    protected var onItemClickListener: ((String) -> Unit)? = null
    protected var onDeleteClickListener: ((String) -> Unit)? = null

    fun setItemClickListener(listener: (String) -> Unit) {
        onItemClickListener = listener
    }

    fun setDeleteClickListener(listener: (String) -> Unit) {
        onDeleteClickListener = listener
    }

}