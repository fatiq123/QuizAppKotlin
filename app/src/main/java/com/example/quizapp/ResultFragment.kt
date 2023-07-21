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

//        // Get the quiz result data from the arguments
//        arguments?.let {
//            val args = ResultFragmentArgs.fromBundle(it)
//            quizResult = args.quizResult
//
//        }
//
//        // Display the score and percentage in TextViews
//        binding.scoreTextView.text = getString(R.string.score, quizResult?.score)
//        binding.percentageTextView.text = getString(R.string.percentage, quizResult?.percentage)
//
//        // Set click listener for the "Finish" button
//        binding.btnFinish.setOnClickListener {
//            // Navigate back to the HomeFragment
//            findNavController().navigateUp()
//        }


//
//        // Get the result data from the QuizViewModel or any other appropriate source
//        val result = QuizViewModel.getResult() // Replace QuizViewModel with the actual ViewModel class
//
//        // Display the result in TextView
//        binding.scoreTextView.text = "Your Score is: ${result.score}/${result.totalQuestions}"
//
//        // Set click listener for the "Back" button
//        binding.btnFinish.setOnClickListener {
//            // Navigate back to the HomeFragment or the appropriate destination
//            findNavController().popBackStack() // This will navigate back to the previous fragment
//        }




        // Get the score and totalQuestions from the arguments
        val score = arguments?.getInt("score", 0) ?: 0
        val totalQuestions = arguments?.getInt("totalQuestions", 0) ?: 0

        // Display the score and percentage in TextViews
        binding.scoreTextView.text = getString(R.string.score, score)
        Log.i("Tag", "problem here")
        binding.percentageTextView.text = getString(R.string.percentage, calculatePercentage(score, totalQuestions))

        // Set click listener for the "Finish" button
        binding.btnFinish.setOnClickListener {
            // Navigate back to the HomeFragment
            findNavController().navigateUp()
        }

        return binding.root
    }


    // Calculate the percentage
    private fun calculatePercentage(score: Int, totalQuestions: Int): Int {
        return (score.toFloat() / totalQuestions.toFloat() * 100).toInt()
    }

}