package com.techun.twitterui.ui.bottomNavigationView.adapters.search.trending

import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.techun.twitterui.databinding.ItemLayoutTrendsBinding
import com.techun.twitterui.domain.TrendModel

abstract class TrendBaseAdapter(private val layoutId: Int) :
    RecyclerView.Adapter<TrendBaseAdapter.TrendViewHolder>() {

    class TrendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemLayoutTrendsBinding.bind(itemView)
        fun render(notification: TrendModel) {
            binding.tvTrending.text = notification.trendIn
            binding.tvName.text = notification.trendName

            val tweets = notification.trendDitails
            if (!tweets.isNullOrEmpty()) {
                binding.tvTweets.visibility = VISIBLE
                binding.tvTweets.text = notification.trendDitails
            } else
                binding.tvTweets.visibility = GONE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendViewHolder {
        return TrendViewHolder(
            LayoutInflater.from(parent.context).inflate(
                layoutId,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = spaces.size

    protected val diffCallback = object : DiffUtil.ItemCallback<TrendModel>() {
        override fun areItemsTheSame(
            oldItem: TrendModel,
            newItem: TrendModel
        ): Boolean {
            return oldItem.idTrend == newItem.idTrend
        }

        override fun areContentsTheSame(
            oldItem: TrendModel,
            newItem: TrendModel
        ): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    protected abstract val differ: AsyncListDiffer<TrendModel>

    open var spaces: List<TrendModel>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    protected var onItemClickListener: ((TrendModel) -> Unit)? = null
    protected var onDeleteClickListener: ((TrendModel) -> Unit)? = null

    fun setItemClickListener(listener: (TrendModel) -> Unit) {
        onItemClickListener = listener
    }

    fun setDeleteClickListener(listener: (TrendModel) -> Unit) {
        onDeleteClickListener = listener
    }

}