package com.example.quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.adapter.CategoryAdapter
import com.example.quizapp.model.QuizResult


class HomeFragment : Fragment() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)


        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Sample list of categories (replace with your actual categories)
        val categories = listOf("Math", "Physics", "Computer Science", "History", "Biology")

        // Set up the RecyclerView adapter with item click handling
        categoryAdapter = CategoryAdapter(categories) { selectedCategory ->
            // Handle the click and redirect the user to the selected quiz
            redirectToQuiz(selectedCategory)
        }
        recyclerView.adapter = categoryAdapter


        // Initialize NavController
        navController = findNavController() // this is very important


        return view
    }


    // Redirect the user to the selected quiz based on the category
    private fun redirectToQuiz(selectedCategory: String) {
        // Replace this with your logic to redirect the user to the selected quiz
        // For example, you can use Navigation Component to navigate to the quiz fragment
        // and pass the selectedCategory as an argument.
        // val action = HomeFragmentDirections.actionHomeFragmentToQuizFragment(selectedCategory)
        // navController.navigate(action)

        when (selectedCategory) {
            "Math" -> {
                val action = HomeFragmentDirections.actionHomeFragmentToMathsQuizFragment()
                navController.navigate(action)
            }

            "Physics" -> {
                val action = HomeFragmentDirections.actionHomeFragmentToPhysicsFragment()
                navController.navigate(action)
            }

            "Computer Science" -> {
                val action = HomeFragmentDirections.actionHomeFragmentToComputerScienceFragment()
                navController.navigate(action)
            }

            "History" -> {
                val action = HomeFragmentDirections.actionHomeFragmentToHistoryFragment()
                navController.navigate(action)
            }

            "Biology" -> {
                val action = HomeFragmentDirections.actionHomeFragmentToBiologyFragment()
                navController.navigate(action)
            }

        }


        // Collect user's selected answers and correct answers from the quiz fragment (replace this with your actual implementation)
        val userSelectedAnswers = listOf("Option 1", "Option 3", "Option 2", "Option 4", "Option 1")
        val correctAnswers = listOf("Correct", "Correct", "Correct", "Incorrect", "Correct")

        // Calculate the user's score and percentage
        val userScore = calculateUserScore(userSelectedAnswers, correctAnswers)
        val userPercentage = calculateUserPercentage(userScore, correctAnswers.size)

        // Create a QuizResult instance with the score, percentage, selected answers, and correct answers
        val quizResult = QuizResult(
            score = userScore,
            percentage = userPercentage,
            selectedAnswers = userSelectedAnswers,
            correctAnswers = correctAnswers
        )

        // Navigate to the ResultFragment and pass the QuizResult as an argument
        navigateToResultFragment(quizResult = quizResult)


    }


    private fun calculateUserPercentage(): Float {
        return 10.0f
    }

    private fun calculateUserScore(): Int {
        return 10
    }

    // Function to navigate to the ResultFragment and pass the QuizResult as an argument
    private fun navigateToResultFragment(quizResult: QuizResult) {
        val action = HomeFragmentDirections.actionHomeFragmentToResultFragment(quizResult)
        navController.navigate(action)
    }

}