package com.pam.bmi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText weightInput;
    private EditText heightInput;
    private EditText ageInput;
    private TextView bmiOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightInput = findViewById(R.id.weight_input);
        heightInput = findViewById(R.id.height_input);
        ageInput = findViewById(R.id.age_input);
        bmiOutput = findViewById(R.id.bmi_output);

        Button calculateButton = findViewById(R.id.calculate_button);
        calculateButton.setOnClickListener(view -> {
            double weight = Double.parseDouble((weightInput.getText().toString()));
            double height = Double.parseDouble(heightInput.getText().toString()) / 100;
            int age = Integer.parseInt(ageInput.getText().toString());

            double bmi = calculateBMI(weight, height);

            String message = getBMIMessage(bmi, age);

            bmiOutput.setText(String.format("Your BMI is %.2f. %s.", bmi, message));
        });
    }

    private double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }

    private String getBMIMessage(double bmi, int age) {
        String message;
        if (age < 18) {
            if (bmi < 18.5) {
                message = "You are underweight";
            } else if (bmi >= 18.5 && bmi < 25) {
                message = "You are at a healthy weight";
            } else if (bmi >= 25 && bmi < 30) {
                message = "You are overweight";
            } else {
                message = "You are obsese";
            }
        } else {
            if (bmi < 18.5) {
                message = "You are underweight";
            } else if (bmi >= 18.5 && bmi < 24.9) {
                message = "You are at a healthy weight";
            } else if (bmi >= 25 && bmi < 29.9) {
                message = "You are overweight";
            } else {
                message = "You are obsese";
            }
        }
        return message;
    }
}