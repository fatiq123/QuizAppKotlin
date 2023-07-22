package com.example.quizapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.R
import com.example.quizapp.model.QuizResultItem

class QuizResultsAdapter(
    private val quizResults: List<QuizResultItem>,
) : RecyclerView.Adapter<QuizResultsAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvQuizTitle: TextView = itemView.findViewById(R.id.tvQuizTitle)
        val tvScore: TextView = itemView.findViewById(R.id.tvScore)
        val tvPercentage: TextView = itemView.findViewById(R.id.tvPercentage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_quiz_result, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return quizResults.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val resultItem = quizResults[position]
        holder.tvQuizTitle.text = resultItem.quizTitle
        holder.tvScore.text = "Score: ${resultItem.score}"
        holder.tvPercentage.text = "Percentage: ${resultItem.percentage}%"
    }
}