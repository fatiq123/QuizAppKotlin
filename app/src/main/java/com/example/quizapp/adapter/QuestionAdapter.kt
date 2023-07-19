package com.example.quizapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.R
import com.example.quizapp.model.Question

class QuestionAdapter(
    private val questions: List<Question>,
) : RecyclerView.Adapter<QuestionAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_question, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return questions.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val question = questions[position]

    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var questionDescription: TextView =
            itemView.findViewById(R.id.questionDescriptionTextView)
        private var option1: TextView = itemView.findViewById(R.id.tvOption1)
        private var option2: TextView = itemView.findViewById(R.id.tvOption2)
        private var option3: TextView = itemView.findViewById(R.id.tvOption3)


        fun bind(question: Question) {
            questionDescription.text = question.questionText
            option1.text = question.options[0]
            option2.text = question.options[1]
            option3.text = question.options[2]
            // Bind other options here if needed
        }
    }


}