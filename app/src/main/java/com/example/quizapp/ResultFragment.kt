package com.example.quizapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.quizapp.databinding.FragmentResultBinding
import com.example.quizapp.model.QuizResult
import com.example.quizapp.viewmodel.QuizViewModel

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding
    private var quizResult: QuizResult? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)

          // Get the arguments from the bundle
        arguments?.let {
            val score = ResultFragmentArgs.fromBundle(it).score
            val percentage = ResultFragmentArgs.fromBundle(it).totalQuestions

            // Display the score and percentage in TextViews
            binding.scoreTextView.text = getString(R.string.score, score)
            binding.percentageTextView.text = getString(R.string.percentage, percentage)

            // Set click listener for the "Finish" button
            binding.btnFinish.setOnClickListener {
                // Navigate back to the HomeFragment
                findNavController().navigateUp()
            }
        }

        return binding.root
    }


    // Calculate the percentage
    private fun calculatePercentage(score: Int, totalQuestions: Int): Int {
        return (score.toFloat() / totalQuestions.toFloat() * 100).toInt()
    }

}