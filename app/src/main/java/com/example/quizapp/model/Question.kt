package com.example.quizapp.model

data class Question(
    val id: Int,
    val questionText: String,
    val options: List<String>,
    val correctOptionIndex: Int,
    var selectedOptionIndex: Int = -1 // Default value -1 indicates no option is selected
)

