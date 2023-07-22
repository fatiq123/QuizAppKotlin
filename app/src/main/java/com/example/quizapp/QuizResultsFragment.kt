package com.example.quizapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizapp.adapter.QuizResultsAdapter
import com.example.quizapp.databinding.FragmentQuizResultsBinding
import com.example.quizapp.model.QuizResultItem

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

//        // Retrieve quiz results from shared preferences (Replace this with your logic)
//        val quizResults = listOf(
//            QuizResultItem("Quiz 1", 8, 80f),
//            QuizResultItem("Quiz 2", 10, 100f),
//            QuizResultItem("Quiz 3", 5, 50f)
//        )

//        // Display the quiz results in a RecyclerView using the QuizResultsAdapter
//        resultsAdapter = QuizResultsAdapter(quizResults)
//        binding.recyclerViewResults.layoutManager = LinearLayoutManager(requireContext())
//        binding.recyclerViewResults.adapter = resultsAdapter








        // Retrieve quiz results from shared preferences
        val sharedPreferences = requireContext().getSharedPreferences("QuizResults", Context.MODE_PRIVATE)
        val score = sharedPreferences.getInt("score", 0)
        val percentage = sharedPreferences.getFloat("percentage", 0f)

        // Display the quiz results in a RecyclerView using the QuizResultsAdapter
        val resultsList = mutableListOf<QuizResultItem>()
        resultsList.add(QuizResultItem("Quiz 1", score, percentage))
        // Add more items as needed for other quiz results

        resultsAdapter = QuizResultsAdapter(resultsList)
        binding.recyclerViewResults.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewResults.adapter = resultsAdapter

    }


}