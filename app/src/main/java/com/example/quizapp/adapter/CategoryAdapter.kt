package com.example.quizapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.R

class CategoryAdapter(
    private val categories: List<String>,
    private val onItemClick: (String) -> Unit,
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categories[position]
        holder.bind(category)
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val categoryNameTextView: TextView =
            itemView.findViewById(R.id.categoryNameTextView)

        fun bind(category: String) {
            categoryNameTextView.text = category

            // Set click listener on the item view
            itemView.setOnClickListener {
                onItemClick(category)
            }
        }

    }

}