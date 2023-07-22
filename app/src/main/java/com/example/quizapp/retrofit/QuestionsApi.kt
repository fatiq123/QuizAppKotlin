package com.example.quizapp.retrofit

import com.example.quizapp.model.QuestionsList
import retrofit2.Response
import retrofit2.http.GET

interface QuestionsApi {

    @GET("questionsapi.php")
    suspend fun getQuestions(): Response<QuestionsList>

    @GET("questionsphysicsapi.php")
    suspend fun getPhysicsQuestions(): Response<QuestionsList>

    @GET("uestioncomputerscienceapi.php")
    suspend fun getComputerScienceQuestions(): Response<QuestionsList>

    @GET("questionhistoryapi.php")
    suspend fun getHistoryQuestions(): Response<QuestionsList>

    @GET("questiongeneralknowledge.php")
    suspend fun getGeneralKnowledgeQuestions(): Response<QuestionsList>

}