package com.example.completeandroidknowledge.sectionPublic

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.completeandroidknowledge.R
import com.example.completeandroidknowledge.commons.BaseObservable
import com.example.completeandroidknowledge.commons.controllers.BaseActivity
import com.example.completeandroidknowledge.commons.navigation.Navigation
import com.example.completeandroidknowledge.commons.navigation.NavigationActivity
import com.example.completeandroidknowledge.databinding.ActivityPublicBinding

class PublicActivity : BaseActivity(),PublicActivityMVCView.Listener {

    private lateinit var activityMVCViewImpl: PublicActivityMVCViewImpl
    private lateinit var navigationActivity: NavigationActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMVCViewImpl = activityCompositionRoot!!.getActivityMVCView(this)
        val navController =  this.findNavController(R.id.insert_point)
        super.setNavController(navController)
        navigationActivity = activityCompositionRoot!!.getNavigationActivity()
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return activityCompositionRoot!!.navController!!.navigateUp()
    }

    override fun onStart() {
        activityMVCViewImpl.registerListener(this)
        super.onStart()
    }

    override fun onStop() {
        activityMVCViewImpl.unregisterListener(this)
        super.onStop()
    }

    override fun onClickOnHome() {
        navigationActivity.updateOnHomeClicked()
    }

    override fun onClickOnProductsInfo() {
        navigationActivity.updateOnProductsInfoClicked()
    }

    override fun onClickInOnNews() {
        navigationActivity.updateOnNewsClicked()
    }
}
