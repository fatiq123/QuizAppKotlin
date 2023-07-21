package com.example.quizapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizapp.model.Question
import com.example.quizapp.model.QuestionsList
import com.example.quizapp.repository.QuizRepository
import kotlinx.coroutines.launch

class QuizViewModel : ViewModel() {

    private val repository: QuizRepository = QuizRepository()
    private val questionsLiveData: MutableLiveData<List<Question>> = MutableLiveData()

    init {
        fetchQuestions()
    }

    private fun fetchQuestions() {
        viewModelScope.launch {
            val questions = repository.getQuestionsFromAPI()
            questionsLiveData.postValue(questions)
        }
    }

    fun getQuestionsFromLiveData(): LiveData<List<Question>> {
        return questionsLiveData
    }

}
