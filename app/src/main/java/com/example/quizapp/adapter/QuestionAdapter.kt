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

            // Bind other options here if needed


            option1.setOnClickListener {
                onOptionClicked(question = question, 0)
            }
            option2.setOnClickListener {
                onOptionClicked(question = question, 1)
            }
            option3.setOnClickListener {
                onOptionClicked(question = question, 3)
            }
            option4.setOnClickListener {
                onOptionClicked(question = question, 4)
            }


            // Determine if the current option is selected or not
            val isSelectedOption = adapterPosition == question.selectedOptionIndex

            // Check if the selected option is correct or not
            val isCorrectOption = adapterPosition == question.correctOptionIndex

            // Reset the background and text colors to their default state
            resetViewColors()


            // Update the background and text colors based on the selection and correctness
            itemView.setBackgroundResource(
                if (question.selectedOptionIndex == adapterPosition) {
                    if (question.selectedOptionIndex == question.correctOptionIndex) R.drawable.option_background_correct
                    else R.drawable.option_background_incorrect
                } else R.drawable.option_background_default
            )

            option1.setTextColor(
                ContextCompat.getColor(
                    itemView.context,
                    if (question.selectedOptionIndex == adapterPosition) {
                        if (question.selectedOptionIndex == question.correctOptionIndex) android.R.color.white
                        else R.color.incorrect_option_text
                    } else android.R.color.black
                )
            )

            option2.setTextColor(
                ContextCompat.getColor(
                    itemView.context,
                    if (question.selectedOptionIndex == adapterPosition) {
                        if (question.selectedOptionIndex == question.correctOptionIndex) android.R.color.white
                        else R.color.incorrect_option_text
                    } else android.R.color.black
                )
            )

            option3.setTextColor(
                ContextCompat.getColor(
                    itemView.context,
                    if (question.selectedOptionIndex == adapterPosition) {
                        if (question.selectedOptionIndex == question.correctOptionIndex) android.R.color.white
                        else R.color.incorrect_option_text
                    } else android.R.color.black
                )
            )

            option4.setTextColor(
                ContextCompat.getColor(
                    itemView.context,
                    if (question.selectedOptionIndex == adapterPosition) {
                        if (question.selectedOptionIndex == question.correctOptionIndex) android.R.color.white
                        else R.color.incorrect_option_text
                    } else android.R.color.black
                )
            )

            // Update other option TextViews if needed
        }


        private fun onOptionClicked(question: Question, optionIndex: Int) {
            // Update the selectedOptionIndex of the question when an option is clicked
            question.selectedOptionIndex = optionIndex
            notifyDataSetChanged() // Notify adapter to update the view
        }


        private fun resetViewColors() {
            itemView.setBackgroundResource(R.drawable.option_background_default)
            option1.setTextColor(ContextCompat.getColor(itemView.context, android.R.color.black))
            option2.setTextColor(ContextCompat.getColor(itemView.context, android.R.color.black))
            option3.setTextColor(ContextCompat.getColor(itemView.context, android.R.color.black))
            option4.setTextColor(ContextCompat.getColor(itemView.context, android.R.color.black))
            // Reset colors for other option TextViews if needed
        }
    }

}

