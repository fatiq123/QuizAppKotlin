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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)

          // Get the arguments from the bundle
        arguments?.let {
            val score = ResultFragmentArgs.fromBundle(it).score
            val percentage = ResultFragmentArgs.fromBundle(it).percentage
//            val totalQuestions = Constants.TOTAL_QUESTIONS // Total number of questions
//            val incorrectAnswers = totalQuestions - score
            //val totalQuestions = ResultFragmentArgs.fromBundle(it).totalQuestions   // not working

            // Display the score, percentage, and number of incorrect answers in TextViews
            binding.scoreTextView.text = getString(R.string.score, score)
            binding.percentageTextView.text = getString(R.string.percentage, percentage)
            //binding.incorrectTextView.text = getString(R.string.incorrect_answers, totalQuestions)

            // Set click listener for the "Finish" button
            binding.btnFinish.setOnClickListener {
                // Navigate back to the HomeFragment using the action ID
                findNavController().navigate(R.id.action_resultFragment_to_homeFragment)
            }
        }

        return binding.root
    }

}