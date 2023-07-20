package com.example.quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.quizapp.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)

//        // Retrieve the JSON string using Safe Args
//        val args: ResultFragmentArgs by navArgs()
//        val quizResult = args.quizResult
//
//        // Display the user's score and percentage
//        binding.scoreTextView.text = getString(R.string.score, quizResult.score)
//        binding.percentageTextView.text = getString(R.string.percentage, quizResult.percentage)

        // Evaluate and display the user's selected answers and correct answers
        // (existing code for displaying selected answers and correct answers)

        return binding.root
    }

}