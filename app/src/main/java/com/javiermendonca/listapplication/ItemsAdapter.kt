package com.javiermendonca.listapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.viewholder_item.view.*

class ItemsAdapter(private val descriptionList: List<String>) : RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val cardView = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_item, parent, false) as CardView
        return ItemViewHolder(cardView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) = with(holder.card) {
        title.text = "Title $position"
        description.text = descriptionList[position]
    }

    override fun getItemCount() = descriptionList.size
}
