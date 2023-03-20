package com.pam.bmi.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.pam.bmi.databinding.FragmentReceipesBinding;

public class ReceipesFragment extends Fragment {

    private FragmentReceipesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ReceiveTwoViewModel receiveTwoViewModel =
                new ViewModelProvider(this).get(ReceiveTwoViewModel.class);
        RecipeOneViewModel recipeOneViewModel =
                new ViewModelProvider(this).get(RecipeOneViewModel.class);

        binding = FragmentReceipesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView recipe1 = binding.textRecipe1;
        final TextView recipe2 = binding.textRecipe2;
        receiveTwoViewModel.getText().observe(getViewLifecycleOwner(), recipe1::setText);
        recipeOneViewModel.getText().observe(getViewLifecycleOwner(), recipe2::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}