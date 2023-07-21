package com.example.quizapp.quizfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.Constants
import com.example.quizapp.adapter.QuestionAdapter
import com.example.quizapp.databinding.FragmentMathsQuizBinding
import com.example.quizapp.model.Question
import com.example.quizapp.model.QuizResult
import com.example.quizapp.viewmodel.QuizViewModel
import kotlinx.coroutines.DelicateCoroutinesApi

class MathsQuizFragment : Fragment() {

    private lateinit var binding: FragmentMathsQuizBinding

    private lateinit var recyclerView: RecyclerView
    private lateinit var questionAdapter: QuestionAdapter
    private lateinit var quizViewModel: QuizViewModel /*by viewModels()*/
    private lateinit var questionsList: List<Question>
    private var currentQuestionIndex = 0
    private var result = 0
    private var incorrectAnswers = 0


    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMathsQuizBinding.inflate(inflater, container, false)

        // Initialize the ViewModel
        quizViewModel = ViewModelProvider(this)[QuizViewModel::class.java]

        // Observe the LiveData for questions and update UI when data is available
        quizViewModel.getQuestionsFromLiveData().observe(viewLifecycleOwner, Observer { questions ->
            if (questions.isNotEmpty()) {
                questionsList = questions
                displayQuestion()
            }
        })

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
                            binding.tvResult.text = "Correct Answer: $result"
                        } else {
                            // Increment the incorrectAnswers and update the TextView
                            incorrectAnswers++
                            binding.tvIncorrect.text = "Incorrect Answer: $incorrectAnswers"
                        }

                        // Display the next question
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

                        // Handle navigation to the ResultFragment here
                        val action = MathsQuizFragmentDirections.actionMathsQuizFragmentToResultFragment3(
                            score = score, percentage = percentage)
                        findNavController().navigate(action)
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



        return binding.root


    }


    private fun displayQuestion() {
        if (currentQuestionIndex < questionsList.size) {
            binding.apply {
                tvQuestion.text = "Question ${currentQuestionIndex + 1}: " + questionsList[currentQuestionIndex].question
                radio1.text = questionsList[currentQuestionIndex].option1
                radio2.text = questionsList[currentQuestionIndex].option2
                radio3.text = questionsList[currentQuestionIndex].option3
                radio4.text = questionsList[currentQuestionIndex].option4
            }
        } else {
            // Handle the case when there are no more questions
            // For example, show a message or disable the "Next" button
            // You can also navigate to the ResultFragment here if needed
            // For example:
           // val action = MathsQuizFragmentDirections.actionMathsQuizFragmentToResultFragment3( score = score, totalQuestions = percentage)
           // findNavController().navigate(action)
        }
    }



    private fun getSampleQuestions(): List<Question> {
        // Replace this with actual API call to retrieve questions from backend
        // and parse the JSON response into a List<Question>
        // For now, providing sample data
        return listOf(
//            Question(1, "Find the sum of 111 + 222 + 333?", listOf("700", "666", "10", "100"), 1),
//            Question(2, "Subtract 457 from 832", listOf("375", "57", "376", "960"), 0),
//            Question(3, "200 – (96 ÷ 4)?", listOf("105", "176", "26", "16"), 1),
//            Question(4, "Simplify :150 ÷ (6 + 3 x 8) - 5?", listOf("2", "5", "0", "None of these"), 0),
//            Question(5, "50 times of 8 is equal to?", listOf("80", "400", "800", "4000"), 1),
//            Question(6, "110 divided by 10 is?", listOf("11", "10", "5", "None of these"), 0),
//            Question(7, "20+(90÷2) is equal to?", listOf("50", "55", "65", "60"), 2),
//            Question(8, "The product of 82 and 5 is?", listOf("400", "410", "420", "None of these"), 1),
//            Question(9, "Find the missing terms in multiple of 3: 3, 6, 9, __, 15?", listOf("10", "11", "12", "13"), 2),
//            Question(10, "What is the next prime number after 5?", listOf("6", "7", "9", "11"), 1),
            // Add more questions here
        )
    }


        private fun navigateToResultFragment() {
            val quizResult = QuizResult(
                score = result,
                percentage = (result.toFloat() / questionsList.size.toFloat()) * 100,
                selectedAnswers = emptyList(), // Replace this with the user's selected answers
                correctAnswers = emptyList()  // Replace this with the correct answers
            )


        }




    //Function to navigate to the ResultFragment and pass the QuizResult as an argument
    private fun navigateToResultFragment(quizResult: QuizResult) {
//        val action = MathsQuizFragmentDirections.actionMathsQuizFragmentToResultFragment(quizResult = quizResult)
//        findNavController().navigate(action)
    }

}