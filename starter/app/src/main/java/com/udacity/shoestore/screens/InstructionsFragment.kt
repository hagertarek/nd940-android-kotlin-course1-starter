package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        val navController = findNavController()
        val binding = DataBindingUtil.inflate<FragmentInstructionsBinding>(
            inflater,
            R.layout.fragment_instructions,
            container,
            false
        )
        binding.btnPick.setOnClickListener {
            navController.navigate(InstructionsFragmentDirections.actionInstructionsFragmentToShoeListFragment())
        }
        return binding.root
    }

}