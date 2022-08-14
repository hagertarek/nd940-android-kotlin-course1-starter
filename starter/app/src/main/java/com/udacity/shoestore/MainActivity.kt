package com.udacity.shoestore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.plant(Timber.DebugTree())

        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        navController = this.findNavController(R.id.myNavHostFragment)

        appBarConfiguration =
            AppBarConfiguration.Builder(R.id.loginFragment, R.id.shoeListFragment).build()
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
        setSupportActionBar(binding.toolbar)
        binding.toolbar.setNavigationOnClickListener {
            NavigationUI.navigateUp(navController, appBarConfiguration)
        }


    }

    override fun onBackPressed() {
        if (navController.currentDestination?.id == R.id.loginFragment) {
            finish()
        }
        super.onBackPressed()
    }
}
