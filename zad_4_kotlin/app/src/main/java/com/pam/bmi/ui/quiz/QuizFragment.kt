package com.pam.bmi.ui.quiz

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.pam.bmi.R
import com.pam.bmi.ui.models.Question

class QuizFragment : Fragment() {
    private lateinit var mQuestionTextView: TextView
    private lateinit var mRadioGroup: RadioGroup
    private lateinit var mRadioButton1: RadioButton
    private lateinit var mRadioButton2: RadioButton
    private lateinit var mRadioButton3: RadioButton
    private lateinit var mNextButton: Button
    private lateinit var questionList: ArrayList<Question>
    private var mCurrentIndex = 0
    private var mScore = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_quiz, container, false)
        initializeViews(view)
        setOnClickListeners()
        initiateQuestions()
        mCurrentIndex = 0
        mScore = 0
        setQuestion()
        return view
    }

    private fun initializeViews(view: View) {
        mQuestionTextView = view.findViewById(R.id.question_text_view)
        mRadioGroup = view.findViewById(R.id.answer_radio_group)
        mRadioButton1 = view.findViewById(R.id.choice_a_button)
        mRadioButton2 = view.findViewById(R.id.choice_b_button)
        mRadioButton3 = view.findViewById(R.id.choice_c_button)
        mNextButton = view.findViewById(R.id.submit_button)
    }

    private fun setOnClickListeners() {
        mNextButton.setOnClickListener { handleNextButtonClick() }
    }

    private fun handleNextButtonClick() {
        checkAnswer()
        mCurrentIndex++
        if (mCurrentIndex < questionList.size) {
            setQuestion()
        } else {
            endQuiz()
        }
    }

    private fun setQuestion() {
        val currentQuestion = questionList[mCurrentIndex]
        mQuestionTextView.text = currentQuestion.question
        mRadioButton1.text = currentQuestion.answers[0]
        mRadioButton2.text = currentQuestion.answers[1]
        mRadioButton3.text = currentQuestion.answers[2]
        mRadioGroup.clearCheck()
    }

    private fun checkAnswer() {
        val correctAnswerIndex = questionList[mCurrentIndex].correctAnswerIndex
        val selectedAnswerIndex = mRadioGroup.checkedRadioButtonId
        if (selectedAnswerIndex != -1) {
            val selectedAnswer = view?.findViewById<RadioButton>(selectedAnswerIndex)
            val selectedAnswerValue = mRadioGroup.indexOfChild(selectedAnswer)
            if (selectedAnswerValue == correctAnswerIndex) {
                mScore++
            }
        }
    }

    private fun endQuiz() {
        val text = "Your score is $mScore out of ${questionList.size}"
        showEndQuizDialog(text)
    }

    private fun showEndQuizDialog(message: String) {
        val builder = AlertDialog.Builder(context)
        builder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton("Play Again") { _, _ ->
                    mCurrentIndex = 0
                    mScore = 0
                    setQuestion()
                }
        val alert = builder.create()
        alert.show()
    }

    private fun initiateQuestions() {
        questionList = ArrayList()
        for (i in 1..6) {
            val question = Question(
                    resources.getString(resources.getIdentifier("question_$i", "string", requireActivity().packageName)), arrayOf(
                    resources.getString(resources.getIdentifier("q" + i + "_answer_a", "string", requireActivity().packageName)),
                    resources.getString(resources.getIdentifier("q" + i + "_answer_b", "string", requireActivity().packageName)),
                    resources.getString(resources.getIdentifier("q" + i + "_answer_c", "string", requireActivity().packageName))
            ), resources.getInteger(resources.getIdentifier("q" + i + "_answer_correct_index", "integer", requireActivity().packageName))
            )
            questionList.add(question)
        }
    }
}
