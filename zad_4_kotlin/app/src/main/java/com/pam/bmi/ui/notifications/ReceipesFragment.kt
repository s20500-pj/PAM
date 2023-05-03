package com.pam.bmi.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pam.bmi.databinding.FragmentReceipesBinding

class ReceipesFragment : Fragment() {
    private var binding: FragmentReceipesBinding? = null
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val receiveTwoViewModel = ViewModelProvider(this).get(ReceiveTwoViewModel::class.java)
        val recipeOneViewModel = ViewModelProvider(this).get(RecipeOneViewModel::class.java)
        binding = FragmentReceipesBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        val recipe1 = binding!!.textRecipe1
        val recipe2 = binding!!.textRecipe2
        receiveTwoViewModel.text.observe(viewLifecycleOwner) { text: CharSequence? -> recipe1.text = text }
        recipeOneViewModel.text.observe(viewLifecycleOwner) { text: CharSequence? -> recipe2.text = text }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}