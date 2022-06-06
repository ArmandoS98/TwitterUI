package com.techun.twitterui.ui.drawerNavigationView

import android.content.Context
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.techun.twitterui.databinding.RowNavDrawerBinding

class NavigationRVAdapter(
    private var items: ArrayList<NavigationItemModel>,
    private var currentPos: Int
) :
    RecyclerView.Adapter<NavigationRVAdapter.ViewHolder>() {
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            RowNavDrawerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // To highlight the selected item, show different background color
        /*   if (position == currentPos) {
               holder.itemView.setBackgroundColor(
                   ContextCompat.getColor(
                       context,
                       R.color.md_theme_dark_onPrimary_desmiss
                   )
               )
           } else {
               holder.itemView.setBackgroundColor(
                   ContextCompat.getColor(
                       context,
                       android.R.color.transparent
                   )
               )
           }*/

        /*holder.binding.navigationIcon.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP)
        holder.binding.navigationTitle.setTextColor(Color.WHITE)*/
        holder.binding.navigationTitle.text = items[position].title
        val icon = items[position].icon
        if (icon != null)
            holder.binding.navigationIcon.setImageResource(icon)
        else
            holder.binding.navigationIcon.visibility = GONE
    }

    override fun getItemCount() = items.count()

    inner class ViewHolder(val binding: RowNavDrawerBinding) : RecyclerView.ViewHolder(binding.root)
}