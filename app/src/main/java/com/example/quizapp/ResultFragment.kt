package com.example.quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.example.quizapp.databinding.FragmentResultBinding
import com.example.quizapp.model.QuizResult


class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResultBinding.inflate(inflater, container, false)


        // Retrieve the JSON string using Safe Args
        val args: ResultFragmentArgs by navArgs()
        val quizResult = args.quizResult

//        // Convert the JSON string back to the QuizResult object
//        val quizResult = QuizResult.fromJsonString(jsonString)


        // For example:
        binding.scoreTextView.text = getString(R.string.score, quizResult.score)
        binding.percentageTextView.text = getString(R.string.percentage, quizResult.percentage)




//        val quizResult = arguments?.getParcelable<QuizResult>("quizResult")
//
//        // Display the user's score and percentage
//        binding.scoreTextView.text = getString(R.string.score, quizResult?.score)
//        binding.percentageTextView.text = getString(R.string.percentage, quizResult?.percentage)
//
//
//        // Evaluate and display the user's selected answers and correct answers
//        val selectedAnswers = quizResult?.selectedAnswers
//        val correctAnswers = quizResult?.correctAnswers
//
//        if (selectedAnswers != null && correctAnswers != null) {
//            for (i in selectedAnswers.indices) {
//                val selectedAnswer = selectedAnswers[i]
//                val correctAnswer = correctAnswers[i]
//
//                val questionTextView = TextView(requireContext())
//                questionTextView.text = "Q${i + 1}: $selectedAnswer"
//
//                val answerTextView = TextView(requireContext())
//                answerTextView.text = "Correct Answer: $correctAnswer"
//
//                // Add the question and answer TextViews to your layout (LinearLayout, RecyclerView, etc.)
//                binding.resultLayout.addView(questionTextView)
//                binding.resultLayout.addView(answerTextView)
//            }
//        }



        return binding.root
    }


//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//
//        // Receive the QuizResult from arguments
//        val quizResult = arguments?.getParcelable<QuizResult>("quizResult")
//
//        // Use the quizResult object to display the user's score and other info in the fragment
//        if (quizResult != null) {
//            val userScore = quizResult.score
//            val userPercentage = quizResult.percentage
//            // Display the user's score and percentage in the ResultFragment
//            // For example, update TextViews with the score and percentage
//        }
//    }

}