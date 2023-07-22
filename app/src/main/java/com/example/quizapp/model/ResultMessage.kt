package com.example.quizapp.model

import android.media.Image
import androidx.annotation.DrawableRes

data class ResultMessage(
    val message: String,
    @DrawableRes val imageResource: Int
)
