package com.techun.twitterui.ui.drawerNavigationView

import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
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
            val image = game.icon
            if (image != null)
                binding.navigationIcon.loadByResource(game.icon!!)
            else
                binding.navigationIcon.visibility = GONE

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

    protected var onItemClickListener: ((Int) -> Unit)? = null
    protected var onDeleteClickListener: ((Int) -> Unit)? = null

    fun setItemClickListener(listener: (Int) -> Unit) {
        onItemClickListener = listener
    }

    fun setDeleteClickListener(listener: (Int) -> Unit) {
        onDeleteClickListener = listener
    }

    override fun getItemCount() = games.size
}