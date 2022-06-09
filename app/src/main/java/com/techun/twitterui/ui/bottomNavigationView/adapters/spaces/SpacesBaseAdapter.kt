package com.techun.twitterui.ui.bottomNavigationView.adapters.spaces

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.techun.twitterui.R
import com.techun.twitterui.databinding.ItemLayoutSpacesBinding
import com.techun.twitterui.domain.BackgroundColorSpaceModel
import com.techun.twitterui.domain.SpaceModel
import com.techun.twitterui.utils.loadByResource

abstract class SpacesBaseAdapter(private val layoutId: Int) :
    RecyclerView.Adapter<SpacesBaseAdapter.SpacesViewHolder>() {


    class SpacesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val lista = listOf(
            BackgroundColorSpaceModel(R.color.color_card_one, R.color.color_card_subone),
            BackgroundColorSpaceModel(R.color.color_card_second, R.color.color_card_subsecond),
            BackgroundColorSpaceModel(R.color.color_card_third, R.color.color_card_subthird)
        )

        private val binding = ItemLayoutSpacesBinding.bind(itemView)
        fun render(space: SpaceModel) {
            val background = lista.shuffled().random()
            binding.mcvCard.backgroundTintList =
                ContextCompat.getColorStateList(itemView.context, background.firstColor)
            binding.clSubText.backgroundTintList =
                ContextCompat.getColorStateList(itemView.context, background.secondColor)

            val userProfile = space.userProfile
            if (!userProfile.isNullOrEmpty())
                binding.civUserImage.loadByResource(userProfile)
            else
                binding.civUserImage.loadByResource(R.drawable.egg)

            binding.tvTime.text = space.time
            binding.tvTitle.text = space.title
            binding.tvDescriptions.text = space.descriptions
            binding.tvHostName.text = space.subTitle
            binding.tvDescriptions2.text = space.subDescription
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpacesViewHolder {
        return SpacesViewHolder(
            LayoutInflater.from(parent.context).inflate(
                layoutId,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = spaces.size

    protected val diffCallback = object : DiffUtil.ItemCallback<SpaceModel>() {
        override fun areItemsTheSame(oldItem: SpaceModel, newItem: SpaceModel): Boolean {
            return oldItem.idSpace == newItem.idSpace
        }

        override fun areContentsTheSame(oldItem: SpaceModel, newItem: SpaceModel): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    protected abstract val differ: AsyncListDiffer<SpaceModel>

    open var spaces: List<SpaceModel>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    protected var onItemClickListener: ((SpaceModel) -> Unit)? = null
    protected var onDeleteClickListener: ((SpaceModel) -> Unit)? = null

    fun setItemClickListener(listener: (SpaceModel) -> Unit) {
        onItemClickListener = listener
    }

    fun setDeleteClickListener(listener: (SpaceModel) -> Unit) {
        onDeleteClickListener = listener
    }

}