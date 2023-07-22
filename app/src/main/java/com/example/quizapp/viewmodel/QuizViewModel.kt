package com.example.quizapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizapp.model.Question
import com.example.quizapp.repository.QuizRepository
import kotlinx.coroutines.launch

class QuizViewModel : ViewModel() {

    private val repository: QuizRepository = QuizRepository()   // always we have to make a object of repository to use it in view model
    private val questionsLiveData: MutableLiveData<List<Question>> = MutableLiveData()
    private val questionsPhysicsLiveData: MutableLiveData<List<Question>> = MutableLiveData()
    private val questionsComputerScienceLiveData: MutableLiveData<List<Question>> = MutableLiveData()
    private val questionsHistoryLiveData: MutableLiveData<List<Question>> = MutableLiveData()
    private val questionsGeneralKnowledgeLiveData: MutableLiveData<List<Question>> = MutableLiveData()

    init {      // this block will always runs first when viewModel class is called
        fetchQuestions()
        fetchPhysicsQuestions()
        fetchComputerScienceQuestions()
        fetchHistoryQuestions()
        fetchGeneralKnowledgeQuestions()
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

    private fun fetchComputerScienceQuestions() {
        viewModelScope.launch {
            val questions = repository.getComputerScienceQuestionsFromApi()
            questionsComputerScienceLiveData.postValue(questions)
        }
    }

    private fun fetchHistoryQuestions() {
        viewModelScope.launch {
            val questions = repository.getHistoryQuestionsFromAPi()
            questionsHistoryLiveData.postValue(questions)
        }
    }

    private fun fetchGeneralKnowledgeQuestions() {
        viewModelScope.launch {
            val questions = repository.getGeneralKnowledgeQuestionsFromAPi()
            questionsGeneralKnowledgeLiveData.postValue(questions)
        }
    }





    // when we work on different quiz fragments then we will use below functions in our fragments
    // these functions are really very much important
    fun getQuestionsFromLiveData(): LiveData<List<Question>> {
        return questionsLiveData
    }


    fun getPhysicsQuestionsFromLiveData(): LiveData<List<Question>> {
        return questionsPhysicsLiveData
    }

    fun getComputerScienceQuestionsFromLiveData(): LiveData<List<Question>> {
        return questionsComputerScienceLiveData
    }

    fun getHistoryQuestionsFromLiveData(): LiveData<List<Question>> {
        return questionsHistoryLiveData
    }

    fun getGeneralKnowledgeQuestionsFromLiveData(): LiveData<List<Question>> {
        return questionsGeneralKnowledgeLiveData
    }

}
