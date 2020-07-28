package com.example.completeandroidknowledge.sectionPublic

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.completeandroidknowledge.R
import com.example.completeandroidknowledge.commons.controllers.BaseActivity
import com.example.completeandroidknowledge.commons.navigation.Navigation
import com.example.completeandroidknowledge.commons.navigation.NavigationActivity
import com.example.completeandroidknowledge.databinding.ActivityPublicBinding

class PublicActivity : BaseActivity(), PublicActivityMVCView.Listener {

    private lateinit var activityMVCViewImpl: PublicActivityMVCViewImpl
    private lateinit var navController: NavController
    private lateinit var navigationActivity: NavigationActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMVCViewImpl = activityCompositionRoot!!.getActivityMVCView(this)
        navController =  this.findNavController(R.id.insert_point)
        navigationActivity = activityCompositionRoot!!.getNavigationActivity(navController)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

    override fun goFromProductsInfoToLoginFragment() {
        navigationActivity.fromProductsInfoToLoginFragment()
    }

    override fun goFromLoginFragmentToProductsInfo() {
        navigationActivity.fromLoginFragmentToProductsInfo()
    }

    override fun onStart() {
        super.onStart()
        activityMVCViewImpl.registerListener(this)
    }

    override fun onStop() {
        super.onStop()
        activityMVCViewImpl.unregisterListener(this)
    }
}
