package com.example.quizapp.quizfragments

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.R
import com.example.quizapp.adapter.QuestionAdapter
import com.example.quizapp.databinding.FragmentMathsQuizBinding
import com.example.quizapp.databinding.FragmentPhysicsBinding
import com.example.quizapp.model.Question
import com.example.quizapp.model.QuestionPhysics
import com.example.quizapp.viewmodel.QuizViewModel

class PhysicsFragment : Fragment() {

    private lateinit var binding: FragmentPhysicsBinding

    private lateinit var quizViewModel: QuizViewModel /*by viewModels()*/
    private lateinit var questionsList: List<QuestionPhysics>
    private var currentQuestionIndex = 0
    private var result = 0
    private var incorrectAnswers = 0



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPhysicsBinding.inflate(inflater, container, false)


        return binding.root


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // Initialize the ViewModel
        quizViewModel = ViewModelProvider(this)[QuizViewModel::class.java]
        Log.i("Tag", "Before observe")
        // Observe the LiveData for questions and update UI when data is available
        quizViewModel.getPhysicsQuestionsFromLiveData().observe(viewLifecycleOwner, Observer { questions ->
            if (questions.isNotEmpty()) {
                questionsList = questions
                displayQuestion()
            }
        })
        Log.i("Tag", "After observe")
        // Set a click listener on the "Next" button
        binding.btnNext.setOnClickListener {
            val selectedOption = binding.radioGroup.checkedRadioButtonId

            if (selectedOption != -1) {
                val radioButton = view?.findViewById<View>(selectedOption) as RadioButton

                questionsList.let {
                    if (currentQuestionIndex < it.size) {
                        // Check if the selected option is correct
                        if (radioButton.text.toString() == it[currentQuestionIndex].correct_option) {

                            result++
                            binding.tvResult.text = "Correct Answers: $result"

                            radioButton.setBackgroundColor(
                                ContextCompat.getColor(requireContext(), R.color.correct_Option_text)
                            )

                        } else {

                            // Increment the incorrectAnswers and update the TextView
                            incorrectAnswers++
                            binding.tvIncorrect.text = "Incorrect Answers: $incorrectAnswers"

                            radioButton.setBackgroundColor(
                                ContextCompat.getColor(requireContext(), R.color.incorrect_option_text)
                            )
                        }


                        // After a brief delay, reset the background color to the default color
//                        Handler(Looper.getMainLooper()).postDelayed({
//                            binding.radioGroup.clearCheck()
//                            radioButton.setBackgroundResource(android.R.drawable.btn_default)
//                            displayQuestion()
//                        }, 1000)

//                        // Display the next question
                        currentQuestionIndex++
                        displayQuestion()

                        // Checking if it is the last question
                        if (currentQuestionIndex == it.size - 1) {
                            binding.btnNext.text = "Finish"
                        }


                        binding.radioGroup.clearCheck()
                    } else {

                        val score = result
                        val totalQuestions = questionsList.size
                        val percentage = (result.toFloat() / totalQuestions.toFloat()) * 100

//                        // Handle navigation to the ResultFragment here
//                        val action = MathsQuizFragmentDirections.actionMathsQuizFragmentToResultFragment3(
//                            score = score, percentage = percentage)
//                        findNavController().navigate(action)
                    }
                }
            } else {
                Toast.makeText(
                    requireContext(),
                    "Please Select One Option",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        Log.i("Tag", "End observe")

    }


    private fun displayQuestion() {     // ya function fragment khulta sar hi pehla question zaroor dekhaya ga aur dekhana bi chahiya
        Log.i("Tag", "In display Question")
        if (currentQuestionIndex < questionsList.size) {
            binding.apply {
                tvPhysicsQuestion.text = "Question ${currentQuestionIndex + 1}: " + questionsList[currentQuestionIndex].question
                radio1.text = questionsList[currentQuestionIndex].option1
                radio2.text = questionsList[currentQuestionIndex].option2
                radio3.text = questionsList[currentQuestionIndex].option3
                radio4.text = questionsList[currentQuestionIndex].option4


                // Existing code to display the next question...
                // Reset background color of all radio buttons to default
//                for (i in 0 until binding.radioGroup.childCount) {
//                    val radioButton = binding.radioGroup.getChildAt(i) as RadioButton
//                    radioButton.setBackgroundColor(Color.TRANSPARENT)
//                }
            }
        }


    }

}