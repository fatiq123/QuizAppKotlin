package com.example.quizapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.quizapp.databinding.ActivityMainBinding
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.quizapp.databinding.FragmentHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var homeBinding: FragmentHomeBinding

    private lateinit var navController: NavController
    private lateinit var customToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


//        // Set the toolbar as the ActionBar
//        val toolbar: Toolbar = findViewById(R.id.toolbar)
//        setSupportActionBar(toolbar)

        // Find the custom Toolbar by ID
        customToolbar = findViewById(R.id.customToolbar)
        setSupportActionBar(customToolbar)


//        navController = findNavController(R.id.fragmentContainerView)
//        setupActionBarWithNavController(navController)


        // Find the NavHostFragment using its ID
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        // Get the NavController from the NavHostFragment
        navController = navHostFragment.navController

        // Set up the ActionBar with the NavController
        setupActionBarWithNavController(navController)



//        // Set up the Up button (Back button)
//        val actionBar = supportActionBar
//        if (actionBar != null) {
//            actionBar.setDisplayHomeAsUpEnabled(true)
//        }



    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }




    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.bottom_navigation_menu, menu)

        // Get the ID of the current destination
        val currentDestinationId = navController.currentDestination?.id

        // Hide the Toolbar (ActionBar) for the specific fragment
        if (currentDestinationId == R.id.loginFragment) {
            supportActionBar?.hide()
        } else {
            supportActionBar?.show()
        }

        return true
    }



}