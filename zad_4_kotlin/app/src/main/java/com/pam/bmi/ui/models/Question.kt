package com.pam.bmi.ui.models

class Question(var question: String, var answers: Array<String?>, var correctAnswerIndex: Int) {

    fun setQuestionId(questionId: String) {
        question = questionId
    }
}