package com.techun.twitterui.ui.drawerNavigationView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.techun.twitterui.databinding.RowNavDrawerBinding
import com.techun.twitterui.utils.loadByResource

abstract class NavigationBaseRVAdapter(private val layoutId: Int) :
    RecyclerView.Adapter<NavigationBaseRVAdapter.GameViewHolder>() {

    class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = RowNavDrawerBinding.bind(itemView)
        fun render(game: NavigationItemModel) {
            binding.navigationIcon.loadByResource(game.icon!!)
            binding.navigationTitle.text = game.title
        }
    }

    protected val diffCallback = object : DiffUtil.ItemCallback<NavigationItemModel>() {
        override fun areItemsTheSame(
            oldItem: NavigationItemModel,
            newItem: NavigationItemModel
        ): Boolean {
            return oldItem.icon == newItem.icon
        }

        override fun areContentsTheSame(
            oldItem: NavigationItemModel,
            newItem: NavigationItemModel
        ): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    protected abstract val differ: AsyncListDiffer<NavigationItemModel>

    open var games: List<NavigationItemModel>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        return GameViewHolder(
            LayoutInflater.from(parent.context).inflate(
                layoutId,
                parent,
                false
            )
        )
    }

    protected var onItemClickListener: ((NavigationItemModel) -> Unit)? = null
    protected var onDeleteClickListener: ((NavigationItemModel) -> Unit)? = null

    fun setItemClickListener(listener: (NavigationItemModel) -> Unit) {
        onItemClickListener = listener
    }

    fun setDeleteClickListener(listener: (NavigationItemModel) -> Unit) {
        onDeleteClickListener = listener
    }

    override fun getItemCount() = games.size
}