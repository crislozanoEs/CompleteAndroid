package com.example.completeandroidknowledge.sectionPublic

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.completeandroidknowledge.R
import com.example.completeandroidknowledge.commons.controllers.BaseActivity
import com.example.completeandroidknowledge.databinding.ActivityPublicBinding

class PublicActivity : BaseActivity() {

    private lateinit var binding: ActivityPublicBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_public)
        navController =  this.findNavController(R.id.insert_point)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}
