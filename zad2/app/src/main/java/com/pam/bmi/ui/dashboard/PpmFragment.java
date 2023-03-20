package com.pam.bmi.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.pam.bmi.R;
import com.pam.bmi.databinding.FragmentPpmBinding;

public class PpmFragment extends Fragment {

    private FragmentPpmBinding binding;

    private EditText weightInput;
    private EditText heightInput;
    private EditText ageInput;
    private EditText sexInput;
    private TextView bmiOutput;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentPpmBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        weightInput = root.findViewById(R.id.weight_input);
        heightInput = root.findViewById(R.id.height_input);
        ageInput = root.findViewById(R.id.age_input);
        bmiOutput = root.findViewById(R.id.bmi_output);
        sexInput = root.findViewById(R.id.sex_input);

        Button calculateButton = root.findViewById(R.id.calculate_button);
        calculateButton.setOnClickListener(view -> {
            double weight = Double.parseDouble((weightInput.getText().toString()));
            double height = Double.parseDouble(heightInput.getText().toString());
            int age = Integer.parseInt(ageInput.getText().toString());
            int sex = Integer.parseInt(sexInput.getText().toString());

            double bmi = calculatePPM(weight, height, age, sex);

            bmiOutput.setText(String.format("Your PPM is %.2f.", bmi));
        });

        return root;
    }

    private double calculatePPM(double weight, double height, int age, int sex) {
        switch (sex) {
            case 1:
                return 655.1f + (9.563f * weight) + (1.85f * height) - (4.676f * age);
            case 0:
                return 66.5f + (13.75f * weight) + (5.003f * height) - (6.775f * age);
        }
        return 0;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}