package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentWelcomeBinding>(
            inflater,
            R.layout.fragment_welcome,
            container,
            false
        )
        navController = findNavController()
        binding.btnStart.setOnClickListener {
            navController.navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment())
        }
        return binding.root
    }

}