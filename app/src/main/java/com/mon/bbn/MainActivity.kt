package com.mon.bbn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.mon.bbn.databinding.ActivityMainBinding
import com.mon.bbn.vm.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)

        val navHost = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHost.navController
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        //setup toolbar
        val toolbar = binding.toolbar
        toolbar.title=""
        setSupportActionBar(toolbar)
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration)

        //retrieve viewModel
        val mainViewModel: MainViewModel by viewModels()

    }

}