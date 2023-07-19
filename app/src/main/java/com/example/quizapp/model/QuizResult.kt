package com.example.quizapp.model


data class QuizResult(
    val score: Int,
    val percentage: Float,
    val selectedAnswers: List<String>, // List of user's selected answers
    val correctAnswers: List<String> // List of correct answers
)