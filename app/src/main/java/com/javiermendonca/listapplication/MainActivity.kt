package com.javiermendonca.listapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.javiermendonca.listapplication.model.CardItem
import com.javiermendonca.listapplication.model.HeaderItem

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val itemsAdapter = ItemsAdapter(descriptions)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerview).apply {
            setHasFixedSize(true)
            this.adapter = itemsAdapter
        }
    }

    companion object {
        private val descriptions = listOf(
            HeaderItem("First Category"),
            CardItem("Title 1", "Description 1"),
            CardItem("Title 2", "Description 2"),
            CardItem("Title 3", "Description 3"),
            HeaderItem("Second Category"),
            CardItem("Title 4", "Description 4"),
            CardItem("Title 5", "Description 5")
        )
    }
}


