package com.example.quizapp.model

import com.google.gson.Gson


data class QuizResultItem(
    val quizTitle: String,
    val score: Int,
    val percentage: Float
)