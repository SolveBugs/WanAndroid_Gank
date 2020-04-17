package com.samiu.host.ui.base.nav

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.samiu.host.databinding.NavMenuItemLayoutBinding


/**
 * BottomNaDrawerFragment的adapter
 *
 * @author Samiu 2020/3/31
 */
class NavigationAdapter(
    private val listener: NavigationAdapterListener
) : ListAdapter<NavigationModelItem, NavigationViewHolder<NavigationModelItem>>(
    NavigationModelItem.NavModelItemDiff
) {

    interface NavigationAdapterListener {
        fun onNavMenuItemClicked(item: NavigationModelItem.NavMenuItem)
    }

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NavigationViewHolder<NavigationModelItem> {
        return NavigationViewHolder.NavMenuItemViewHolder(
            NavMenuItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            listener
        ) as NavigationViewHolder<NavigationModelItem>
    }

    override fun onBindViewHolder(
        holder: NavigationViewHolder<NavigationModelItem>,
        position: Int
    ) {
        holder.bind(getItem(position))
    }
}