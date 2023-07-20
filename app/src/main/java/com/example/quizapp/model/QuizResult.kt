package com.example.quizapp.model

import android.os.Parcel
import android.os.Parcelable



data class QuizResult(
    val score: Int,
    val percentage: Float,
    val selectedAnswers: List<String>,
    val correctAnswers: List<String>
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


