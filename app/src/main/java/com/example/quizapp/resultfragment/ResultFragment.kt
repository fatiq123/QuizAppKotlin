package com.example.quizapp.resultfragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.quizapp.R
import com.example.quizapp.databinding.FragmentResultBinding
import com.example.quizapp.model.ResultMessage

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





            // Get the result message and image based on the user's score
            val resultMessage = getResultMessage(score)

            // Display the result message
            binding.resultMessageTextView.text = resultMessage.message

            // Display the result image
            binding.resultImageView.setImageResource(resultMessage.imageResource)







            // Set click listener for the "Finish" button
            binding.btnFinish.setOnClickListener {
                // Navigate back to the HomeFragment using the action ID
                findNavController().navigate(R.id.action_resultFragment_to_homeFragment)
            }





            //----------------------------Shared Preferences----------------------------------------//


            // After the quiz is finished, store the result in shared preferences
            // we can only access getSharedPreference by context or requireContext() in fragments
            // i have do this many times it is not very complex we just getting the score and percentage from this fragment and getting it in QUizResultsFragment
            val sharedPreferences = requireContext().getSharedPreferences("QuizResults", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putInt("score", score)
            editor.putFloat("percentage", percentage)
            editor.apply() // puts the data asynchronously
//                commit()  put the data synchronously and blocks the main thread and UI



        }



        return binding.root
    }


    private fun getResultMessage(score: Int): ResultMessage {
        return when (score) {
            in 0..2 -> ResultMessage("Your score is too low.", R.drawable.quiz_result)
            in 3..7 -> ResultMessage("Good job!", R.drawable.quiz_result)
            else -> ResultMessage("Excellent!", R.drawable.quiz_result)
        }
    }



}








//------------------------------we can also make a variable for args and use it as below----------------------------
// Get the arguments passed from the PhysicsFragment
//val args = ResultFragmentArgs.fromBundle(requireArguments())      // this line is very important
//
//// Display the score and percentage in TextViews
//binding.scoreTextView.text = getString(R.string.score, args.score)
//binding.percentageTextView.text = getString(R.string.percentage, args.percentage)
//
//// Display the number of incorrect answers
//binding.incorrectTextView.text = getString(R.string.incorrect_answers, args.incorrectAnswers)
//
//// Set click listener for the "Finish" button
//binding.btnFinish.setOnClickListener {
//    // Navigate back to the HomeFragment
//    findNavController().navigateUp()
//}