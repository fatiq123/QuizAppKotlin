package com.example.quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quizapp.model.QuizResult


class ResultFragment : Fragment() {

    companion object {
        // Add a newInstance method that accepts the QuizResult argument
        fun newInstance(quizResult: QuizResult): ResultFragment {
            val fragment = ResultFragment()
            val args = Bundle()
            args.putParcelable("quizResult", quizResult)
            fragment.arguments = args
            return fragment
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // Receive the QuizResult from arguments
        val quizResult = arguments?.getParcelable<QuizResult>("quizResult")

        // Use the quizResult object to display the user's score and other info in the fragment
        if (quizResult != null) {
            val userScore = quizResult.score
            val userPercentage = quizResult.percentage
            // Display the user's score and percentage in the ResultFragment
            // For example, update TextViews with the score and percentage
        }



    }

}