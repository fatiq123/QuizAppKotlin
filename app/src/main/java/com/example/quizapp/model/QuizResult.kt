package com.example.quizapp.model

import android.os.Parcel
import android.os.Parcelable


data class QuizResult(
    val score: Int,
    val percentage: Float,
    val selectedAnswers: List<String>, // List of user's selected answers
    val correctAnswers: List<String> // List of correct answers

) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readFloat(),
        parcel.createStringArrayList() ?: emptyList(),
        parcel.createStringArrayList() ?: emptyList()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(score)
        parcel.writeFloat(percentage)
        parcel.writeStringList(selectedAnswers)
        parcel.writeStringList(correctAnswers)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<QuizResult> {
        override fun createFromParcel(parcel: Parcel): QuizResult {
            return QuizResult(parcel)
        }

        override fun newArray(size: Int): Array<QuizResult?> {
            return arrayOfNulls(size)
        }
    }
}

// Extension function to write List<String> to Parcel
fun Parcel.writeStringList(list: List<String>) {
    writeInt(list.size)
    list.forEach { writeString(it) }
}

// Extension function to read List<String> from Parcel
fun Parcel.readStringList(): List<String> {
    val size = readInt()
    return mutableListOf<String>().apply {
        repeat(size) { add(readString() ?: "") }
    }
}
