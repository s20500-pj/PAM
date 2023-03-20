package com.pam.bmi.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.pam.bmi.R;
import com.pam.bmi.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    private EditText weightInput;
    private EditText heightInput;
    private EditText ageInput;
    private TextView bmiOutput;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        weightInput = root.findViewById(R.id.weight_input);
        heightInput = root.findViewById(R.id.height_input);
        ageInput = root.findViewById(R.id.age_input);
        bmiOutput = root.findViewById(R.id.bmi_output);

        Button calculateButton = root.findViewById(R.id.calculate_button);
        calculateButton.setOnClickListener(view -> {
            double weight = Double.parseDouble((weightInput.getText().toString()));
            double height = Double.parseDouble(heightInput.getText().toString()) / 100;
            int age = Integer.parseInt(ageInput.getText().toString());

            double bmi = calculateBMI(weight, height);

            String message = getBMIMessage(bmi, age);

            bmiOutput.setText(String.format("Your BMI is %.2f. %s.", bmi, message));
        });

        return root;
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}