package com.example.quizapp.quizfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.quizapp.R
import com.example.quizapp.adapter.QuestionAdapter
import com.example.quizapp.model.Question

class MathsQuizFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var questionAdapter: QuestionAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_maths_quiz, container, false)



        // Initialize recyclerView
        recyclerView = view.findViewById(R.id.recyclerViewMathQuiz)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        // Sample list of questions (replace with actual data retrieved from API)
        val questions = getSampleQuestions()

        // Set up the RecyclerView adapter
        questionAdapter = QuestionAdapter(questions)
        recyclerView.adapter = questionAdapter


        return view

    }

    private fun getSampleQuestions(): List<Question> {
        // Replace this with actual API call to retrieve questions from backend
        // and parse the JSON response into a List<Question>
        // For now, providing sample data
        return listOf(
            Question(1, "What is 2 + 2?", listOf("3", "4", "5", "6"), 1),
            Question(2, "What is 5 * 8?", listOf("35", "40", "45", "50"), 1),
            Question(3, "What is 5 * 6?", listOf("30", "40", "45", "50"), 0),
            Question(4, "What is 5 * 2?", listOf("10", "40", "45", "50"), 0),
            // Add more questions here
        )
    }

}