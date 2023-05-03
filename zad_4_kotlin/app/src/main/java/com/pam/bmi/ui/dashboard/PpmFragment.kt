package com.pam.bmi.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.pam.bmi.R
import com.pam.bmi.databinding.FragmentPpmBinding

class PpmFragment : Fragment() {
    private var binding: FragmentPpmBinding? = null
    private var weightInput: EditText? = null
    private var heightInput: EditText? = null
    private var ageInput: EditText? = null
    private var sexInput: EditText? = null
    private var bmiOutput: TextView? = null
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPpmBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        weightInput = root.findViewById(R.id.weight_input)
        heightInput = root.findViewById(R.id.height_input)
        ageInput = root.findViewById(R.id.age_input)
        bmiOutput = root.findViewById(R.id.bmi_output)
        sexInput = root.findViewById(R.id.sex_input)
        val calculateButton = root.findViewById<Button>(R.id.calculate_button)
        calculateButton.setOnClickListener { view: View? ->
            val weight = weightInput?.text.toString().toDouble()
            val height = heightInput?.text.toString().toDouble()
            val age = ageInput?.text.toString().toInt()
            val sex = sexInput?.text.toString().toInt()
            val bmi = calculatePPM(weight, height, age, sex)
            bmiOutput?.text = String.format("Your PPM is %.2f.", bmi)
        }
        return root
    }

    private fun calculatePPM(weight: Double, height: Double, age: Int, sex: Int): Double {
        when (sex) {
            1 -> return 655.1f + 9.563f * weight + 1.85f * height - 4.676f * age
            0 -> return 66.5f + 13.75f * weight + 5.003f * height - 6.775f * age
        }
        return 0.0
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}