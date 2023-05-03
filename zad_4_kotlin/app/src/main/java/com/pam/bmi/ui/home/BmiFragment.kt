package com.pam.bmi.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.pam.bmi.R
import com.pam.bmi.databinding.FragmentBmiBinding

class BmiFragment : Fragment() {
    private var binding: FragmentBmiBinding? = null
    private var weightInput: EditText? = null
    private var heightInput: EditText? = null
    private var ageInput: EditText? = null
    private var bmiOutput: TextView? = null
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentBmiBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        weightInput = root.findViewById(R.id.weight_input)
        heightInput = root.findViewById(R.id.height_input)
        ageInput = root.findViewById(R.id.age_input)
        bmiOutput = root.findViewById(R.id.bmi_output)
        val calculateButton = root.findViewById<Button>(R.id.calculate_button)
        calculateButton.setOnClickListener { view: View? ->
            val weight = weightInput?.text.toString().toDouble()
            val height = heightInput?.text.toString().toDouble() / 100
            val age = ageInput?.text.toString().toInt()
            val bmi = calculateBMI(weight, height)
            val message = getBMIMessage(bmi, age)
            bmiOutput?.text = String.format("Your BMI is %.2f. %s.", bmi, message)
        }
        return root
    }

    private fun calculateBMI(weight: Double, height: Double): Double {
        return weight / (height * height)
    }

    private fun getBMIMessage(bmi: Double, age: Int): String {
        val message: String
        message = if (age < 18) {
            if (bmi < 18.5) {
                "You are underweight"
            } else if (bmi >= 18.5 && bmi < 25) {
                "You are at a healthy weight"
            } else if (bmi >= 25 && bmi < 30) {
                "You are overweight"
            } else {
                "You are obsese"
            }
        } else {
            if (bmi < 18.5) {
                "You are underweight"
            } else if (bmi >= 18.5 && bmi < 24.9) {
                "You are at a healthy weight"
            } else if (bmi >= 25 && bmi < 29.9) {
                "You are overweight"
            } else {
                "You are obsese"
            }
        }
        return message
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}