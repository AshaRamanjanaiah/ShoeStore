 package com.udacity.shoestore.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ActivityMainBinding

 class MainActivity : AppCompatActivity() {

     lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = setOf(R.id.loginFragment, R.id.shoeListingFragment)
        )
        binding.toolbar
            .setupWithNavController(navController, appBarConfiguration)

    }

}
