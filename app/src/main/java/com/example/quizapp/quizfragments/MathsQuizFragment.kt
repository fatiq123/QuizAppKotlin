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
import com.example.quizapp.HomeFragmentDirections
import com.example.quizapp.R
import com.example.quizapp.adapter.QuestionAdapter
import com.example.quizapp.model.Question
import com.example.quizapp.model.QuizResult

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





        // Function to handle quiz completion and navigation to the ResultFragment
        fun onQuizCompleted(userSelectedAnswers: List<String>, correctAnswers: List<String>) {
            // Calculate the user's score and percentage
            val userScore = calculateUserScore(userSelectedAnswers = userSelectedAnswers, correctAnswers = correctAnswers)
            val userPercentage = calculateUserPercentage(userScore = userScore, correctAnswers.size)


            // Create a QuizResult instance with the score, percentage, selected answers, and correct answers
            val quizResult = QuizResult(
                score = userScore,
                percentage = userPercentage,
                selectedAnswers = userSelectedAnswers,
                correctAnswers = correctAnswers
            )

            val action = MathsQuizFragmentDirections.actionMathsQuizFragmentToResultFragment(quizResult)
            findNavController().navigate(action)



//            val jsonString = quizResult.toJsonString()
//
//            val action = MathsQuizFragmentDirections.actionMathsQuizFragmentToResultFragment(jsonString)
//            findNavController().navigate(action)
        }







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















    // Function to calculate the user's score based on selected answers and correct answers
    private fun calculateUserScore(
        userSelectedAnswers: List<String>,
        correctAnswers: List<String>
    ): Int {
        var score = 0

        // Iterate through the user's selected answers and correct answers
        for (i in userSelectedAnswers.indices) {
            // Compare each selected answer with the corresponding correct answer
            // Increment the score if the answer is correct
            if (userSelectedAnswers[i] == correctAnswers[i]) {
                score++
            }
        }

        return score
    }

    // Function to calculate the user's percentage based on the score and total number of questions
    private fun calculateUserPercentage(userScore: Int, totalQuestions: Int): Float {
        return (userScore.toFloat() / totalQuestions.toFloat()) * 100
    }




    //Function to navigate to the ResultFragment and pass the QuizResult as an argument
    private fun navigateToResultFragment(quizResult: QuizResult) {
        val action = MathsQuizFragmentDirections.actionMathsQuizFragmentToResultFragment(quizResult = quizResult)
        findNavController().navigate(action)
    }

}