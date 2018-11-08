package com.javiermendonca.listapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.javiermendonca.listapplication.model.CardItem
import com.javiermendonca.listapplication.model.HeaderItem
import com.javiermendonca.listapplication.model.ListItem
import kotlinx.android.synthetic.main.viewholder_card.view.*

class ItemsAdapter(private val descriptionList: List<ListItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return when (descriptionList[position]) {
            is HeaderItem -> HEADER_TYPE
            is CardItem -> CARD_TYPE
            else -> super.getItemViewType(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            HEADER_TYPE -> {
                val header = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_header, parent, false) as TextView
                HeaderViewHolder(header)
            }
            CARD_TYPE -> {
                val cardView =
                    LayoutInflater.from(parent.context).inflate(R.layout.viewholder_card, parent, false) as CardView
                CardViewHolder(cardView)
            }
            else -> TODO("Type $viewType not implemented")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = with(holder) {
        when (this) {
            is HeaderViewHolder -> header.text = (descriptionList[position] as HeaderItem).header
            is CardViewHolder -> {
                card.title.text = (descriptionList[position] as CardItem).title
                card.description.text = (descriptionList[position] as CardItem).description
            }
        }
    }

    override fun getItemCount() = descriptionList.size

    companion object {
        const val HEADER_TYPE = 0
        const val CARD_TYPE = 1
    }
}
