package com.example.quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.adapter.CategoryAdapter
import com.example.quizapp.databinding.FragmentHomeBinding
import com.example.quizapp.model.QuizResult
import com.google.android.material.bottomnavigation.BottomNavigationView


class HomeFragment : Fragment(), BottomNavigationView.OnNavigationItemSelectedListener {


    private lateinit var binding: FragmentHomeBinding

    private lateinit var recyclerView: RecyclerView
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root


        // Initialize RecyclerView
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Sample list of categories (replace with your actual categories)
        val categories = listOf("Math", "Physics", "Computer Science", "History", "General Knowledge")

        // Set up the RecyclerView adapter with item click handling
        categoryAdapter = CategoryAdapter(categories) { selectedCategory ->
            // Handle the click and redirect the user to the selected quiz
            redirectToQuiz(selectedCategory)
        }
        recyclerView.adapter = categoryAdapter



        // Initialize NavController
        navController = findNavController()




        // Set the bottom navigation listener in the HomeFragment
        binding.bottomNavigationView.setOnNavigationItemSelectedListener(this)

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

            "General Knowledge" -> {
                val action = HomeFragmentDirections.actionHomeFragmentToBiologyFragment()
                navController.navigate(action)
            }

        }


    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // Set the bottom navigation listener in the HomeFragment
        binding.bottomNavigationView.setOnNavigationItemSelectedListener(this)
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

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle item selection based on item ID
        when (item.itemId) {
            R.id.miHome -> {
                // If the user clicks on "Home", do nothing since they are already in the HomeFragment
                return true
            }
            R.id.miQuiz -> {
                // If the user clicks on "Quiz", navigate to the QuizFragment
//            val action = HomeFragmentDirections.actionHomeFragmentToQuizFragment()
//            navController.navigate(action)
                return true
            }
            R.id.miAbout -> {
                // If the user clicks on "Profile", navigate to the AboutFragment
                val action = HomeFragmentDirections.actionHomeFragmentToAboutFragment()
                navController.navigate(action)
                return true
            }
            else -> return false
        }
    }


    // Function to navigate to the ResultFragment and pass the QuizResult as an argument
//    private fun navigateToResultFragment(quizResult: QuizResult) {
//        val action = HomeFragmentDirections.actionHomeFragmentToResultFragment()
//        navController.navigate(action)
//    }



}