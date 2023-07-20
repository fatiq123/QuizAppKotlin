package com.example.quizapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.quizapp.model.QuestionsList
import com.example.quizapp.retrofit.QuestionsApi
import com.example.quizapp.retrofit.RetrofitInstance
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class QuizRepository {


    private val questionsAPI: QuestionsApi = RetrofitInstance()
        .getRetrofitInstance()
        .create(QuestionsApi::class.java)

    @OptIn(DelicateCoroutinesApi::class)
    fun getQuestionsFromAPI(): LiveData<QuestionsList> {

        // LiveData
        val data = MutableLiveData<QuestionsList>()

        var questionsList: QuestionsList

        GlobalScope.launch(Dispatchers.IO) {

            // returning the Response<List<QuestionListItem>>
            val response = questionsAPI.getQuestions()

            if (response.isSuccessful) {
                // saving the data to list
                questionsList = response.body()!!

                data.postValue(questionsList)
                Log.v("Tag", "" + data.value)
            }
        }
        return data
    }


}