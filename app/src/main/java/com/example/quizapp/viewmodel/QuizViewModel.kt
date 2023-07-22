package com.example.quizapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizapp.model.Question
import com.example.quizapp.repository.QuizRepository
import kotlinx.coroutines.launch

class QuizViewModel : ViewModel() {

    private val repository: QuizRepository = QuizRepository()
    private val questionsLiveData: MutableLiveData<List<Question>> = MutableLiveData()
    private val questionsPhysicsLiveData: MutableLiveData<List<Question>> = MutableLiveData()

    init {
        fetchQuestions()
        fetchPhysicsQuestions()
    }

    private fun fetchQuestions() {
        viewModelScope.launch {
            val questions = repository.getQuestionsFromAPI()
            questionsLiveData.postValue(questions)
        }
    }


    private fun fetchPhysicsQuestions() {
        viewModelScope.launch {
            val questions = repository.getPhysicsQuestionsFromAPI()
            questionsPhysicsLiveData.postValue(questions)
        }
    }


    fun getQuestionsFromLiveData(): LiveData<List<Question>> {
        return questionsLiveData
    }


    fun getPhysicsQuestionsFromLiveData(): LiveData<List<Question>> {
        return questionsPhysicsLiveData
    }
}
