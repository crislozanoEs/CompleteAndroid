package com.example.completeandroidknowledge.sectionTransactional

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.completeandroidknowledge.R
import com.example.completeandroidknowledge.commons.controllers.BaseActivity
import com.example.completeandroidknowledge.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val navController = this.findNavController(R.id.insert_point_main)
        super.setNavController(navController)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }
}
