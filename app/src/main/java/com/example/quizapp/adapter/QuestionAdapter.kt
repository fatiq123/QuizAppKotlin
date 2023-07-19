package com.example.quizapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
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
        holder.bind(question = question)
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var questionDescription: TextView =
            itemView.findViewById(R.id.questionDescriptionTextView)
        private var option1: TextView = itemView.findViewById(R.id.tvOption1)
        private var option2: TextView = itemView.findViewById(R.id.tvOption2)
        private var option3: TextView = itemView.findViewById(R.id.tvOption3)
        private var option4: TextView = itemView.findViewById(R.id.tvOption4)

        fun bind(question: Question) {
            questionDescription.text = question.questionText
            option1.text = question.options[0]
            option2.text = question.options[1]
            option3.text = question.options[2]
            option4.text = question.options[3]

            // Set click listeners for each option TextView
            option1.setOnClickListener { onOptionClicked(question, 0) }
            option2.setOnClickListener { onOptionClicked(question, 1) }
            option3.setOnClickListener { onOptionClicked(question, 2) }
            option4.setOnClickListener { onOptionClicked(question, 3) }

            // Update the background and text colors based on the selection and correctness
            updateViewColors(question)
        }

        private fun onOptionClicked(question: Question, optionIndex: Int) {
            // Update the selectedOptionIndex of the question when an option is clicked
            question.selectedOptionIndex = optionIndex
            // Notify adapter to update the view
            notifyDataSetChanged()
        }

        private fun updateViewColors(question: Question) {
            // Loop through each option TextView and update their colors based on selection and correctness
            for (i in questions.indices) {
                val optionTextView = when (i) {
                    0 -> option1
                    1 -> option2
                    2 -> option3
                    3 -> option4
                    else -> null
                }

                val isSelectedOption =
                    question.selectedOptionIndex == i        // This line checks if the current option index (represented by i) is equal to the selectedOptionIndex of the question. It returns true if the current option is selected, and false otherwise.
                val isCorrectOption =
                    question.correctOptionIndex == i          // This line checks if the current option index (represented by i) is equal to the correctOptionIndex of the question. It returns true if the current option is the correct answer, and false otherwise.

                optionTextView?.apply {
                    setBackgroundResource(
                        when {
                            isSelectedOption -> {
                                if (isCorrectOption) R.drawable.option_background_correct
                                else R.drawable.option_background_incorrect
                            }

                            else -> R.drawable.option_background_default
                        }
                    )

                    setTextColor(
                        ContextCompat.getColor(
                            itemView.context,
                            when {
                                isSelectedOption -> {
                                    if (isCorrectOption) android.R.color.white
                                    else R.color.incorrect_option_text
                                }

                                else -> android.R.color.black
                            }
                        )
                    )
                }
            }
        }
    }

}

