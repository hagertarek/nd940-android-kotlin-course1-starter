package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.screens.shoelist.ShoeListViewModel

class ShoeDetailsFragment : Fragment() {

    private lateinit var viewModel: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val navController = findNavController()

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentShoeDetailsBinding>(
            inflater,
            R.layout.fragment_shoe_details,
            container,
            false
        )

        viewModel = ViewModelProvider(
            requireActivity()
        ).get(ShoeListViewModel::class.java)

        viewModel.eventItemSaved.observe(viewLifecycleOwner, Observer { itemSaved ->
            if (itemSaved) {
                navController.popBackStack()
                viewModel.onItemSaveComplete()
            }
        })

        binding.shoeListViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.btnCancel.setOnClickListener {
            navController.popBackStack()
        }

        return binding.root
    }

}