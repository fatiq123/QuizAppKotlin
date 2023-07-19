package com.example.quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.adapter.CategoryAdapter


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
        navController = findNavController()

        return view
    }


    // Redirect the user to the selected quiz based on the category
    private fun redirectToQuiz(selectedCategory: String) {
        // Replace this with your logic to redirect the user to the selected quiz
        // For example, you can use Navigation Component to navigate to the quiz fragment
        // and pass the selectedCategory as an argument.
        // val action = HomeFragmentDirections.actionHomeFragmentToQuizFragment(selectedCategory)
        // navController.navigate(action)

        when(selectedCategory) {
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
        }
    }

}