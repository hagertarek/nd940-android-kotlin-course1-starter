package com.udacity.shoestore.screens.shoelist

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screens.login.LoginViewModel
import kotlinx.android.synthetic.main.shoe_list_item.view.*

class ShoeListFragment : Fragment() {

    private lateinit var viewModel: ShoeListViewModel
    private lateinit var binding: FragmentShoeListBinding
    private lateinit var navController: NavController
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        navController = findNavController()
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_list,
            container,
            false
        )
        viewModel = ViewModelProvider(
            requireActivity()
        ).get(ShoeListViewModel::class.java)

        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        viewModel.shoeList.observe(viewLifecycleOwner, Observer { shoes ->
            for (i in 0 until shoes.size) {
                addNewShoe()
                bindShoeData(i, shoes[i])
            }
        })

        binding.btnAdd.setOnClickListener {
            navController.navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsFragment())
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    private fun addNewShoe() {
        val view =
            LayoutInflater.from(context).inflate(R.layout.shoe_list_item, binding.shoesList, false)
        binding.shoesList.addView(view, binding.shoesList.childCount)
    }

    private fun bindShoeData(index: Int, shoe: Shoe) {
        val child = binding.shoesList.getChildAt(index)
        child.tv_shoe_name.text = shoe.name
        child.tv_company_name.text = shoe.company
        child.tv_shoe_size.text = shoe.size.toString()
        child.tv_shoe_description.text = shoe.description

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.loginFragment)
            loginViewModel.logout()

        return NavigationUI.onNavDestinationSelected(item, navController)
                || super.onOptionsItemSelected(item)
    }

}