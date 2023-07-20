package com.example.quizapp.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.Gson
import java.io.Serializable


data class QuizResult(
    val score: Int,
    val percentage: Float,
    val selectedAnswers: List<String>,
    val correctAnswers: List<String>
){
    fun toJsonString(): String {
        val gson = Gson()
        return gson.toJson(this)
    }

    companion object {
        fun fromJsonString(jsonString: String): QuizResult {
            val gson = Gson()
            return gson.fromJson(jsonString, QuizResult::class.java)
        }
    }
}