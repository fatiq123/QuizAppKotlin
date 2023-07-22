package com.example.quizapp.repository

import com.example.quizapp.model.Question
import com.example.quizapp.retrofit.QuestionsApi
import com.example.quizapp.retrofit.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuizRepository {

    private val questionsAPI: QuestionsApi = RetrofitInstance()
        .getRetrofitInstance()
        .create(QuestionsApi::class.java)

    suspend fun getQuestionsFromAPI(): List<Question> {
        return withContext(Dispatchers.IO) {
            val response = questionsAPI.getQuestions()
            if (response.isSuccessful) {
                response.body() ?: emptyList()
            } else {
                emptyList()
            }
        }
    }

    suspend fun getPhysicsQuestionsFromAPI(): List<Question> {
        return withContext(Dispatchers.IO) {
            val response = questionsAPI.getPhysicsQuestions()
            if (response.isSuccessful) {
                response.body() ?: emptyList()
            } else {
                emptyList()
            }
        }
    }


}