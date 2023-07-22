package com.example.quizapp

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizapp.adapter.QuizResultsAdapter
import com.example.quizapp.databinding.FragmentQuizResultsBinding
import com.example.quizapp.model.QuizResultItem
import kotlin.random.Random

class QuizResultsFragment : Fragment() {

    private lateinit var binding: FragmentQuizResultsBinding

    private lateinit var resultsAdapter: QuizResultsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentQuizResultsBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // Retrieve quiz results from shared preferences
        val sharedPreferences =
            requireContext().getSharedPreferences("QuizResults", Context.MODE_PRIVATE)
        val score = sharedPreferences.getInt("score", 0)
        val percentage = sharedPreferences.getFloat("percentage", 0f)

        // Display the quiz results in a RecyclerView using the QuizResultsAdapter
        val resultsList = mutableListOf<QuizResultItem>()
        resultsList.add(QuizResultItem("Quiz 1", score, percentage, getRandomColor()))
        // Add more items as needed for other quiz results


        resultsAdapter = QuizResultsAdapter(resultsList)
        binding.recyclerViewResults.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewResults.adapter = resultsAdapter

    }








    private fun getRandomColor(): Int {
        val colors = arrayOf(
            Color.parseColor("#FFC107"), // Amber
            Color.parseColor("#FF5722"), // Deep Orange
            Color.parseColor("#FF9800"), // Orange
            Color.parseColor("#4CAF50"), // Green
            Color.parseColor("#2196F3"), // Blue
            Color.parseColor("#9C27B0"), // Purple
            Color.parseColor("#E91E63")  // Pink
            // Add more colors as needed
        )

        val randomColorIndex = Random.nextInt(colors.size)
        return colors[randomColorIndex]
    }

}
