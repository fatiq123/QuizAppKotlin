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
            Question(1, "Find the sum of 111 + 222 + 333?", listOf("700", "666", "10", "100"), 1),
            Question(2, "Subtract 457 from 832", listOf("375", "57", "376", "960"), 0),
            Question(3, "200 – (96 ÷ 4)?", listOf("105", "176", "26", "16"), 1),
            Question(4, "Simplify :150 ÷ (6 + 3 x 8) - 5?", listOf("2", "5", "0", "None of these"), 0),
            Question(5, "50 times of 8 is equal to?", listOf("80", "400", "800", "4000"), 1),
            Question(6, "110 divided by 10 is?", listOf("11", "10", "5", "None of these"), 0),
            Question(7, "20+(90÷2) is equal to?", listOf("50", "55", "65", "60"), 2),
            Question(8, "The product of 82 and 5 is?", listOf("400", "410", "420", "None of these"), 1),
            Question(9, "Find the missing terms in multiple of 3: 3, 6, 9, __, 15?", listOf("10", "11", "12", "13"), 2),
            Question(10, "What is the next prime number after 5?", listOf("6", "7", "9", "11"), 1),
            // Add more questions here
        )
    }

}